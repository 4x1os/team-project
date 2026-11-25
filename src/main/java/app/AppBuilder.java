package app;

import javax.swing.*;
// WILL HAVE TO EVENTUALLY REPLACE application.add(signupView); with viewManager
import entity.Prediction;
import entity.PredictionFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.create_prediction.CreatePredictionController;
import interface_adapter.create_prediction.CreatePredictionPresenter;
import interface_adapter.create_prediction.CreatePredictionViewModel;
import interface_adapter.dashboard.DashboardController;
import interface_adapter.dashboard.DashboardPresenter;
import interface_adapter.dashboard.DashboardViewModel;
import use_case.create_prediction.CreatePredictionDataAccessInterface;
import use_case.create_prediction.CreatePredictionInputBoundary;
import use_case.create_prediction.CreatePredictionInteractor;
import use_case.create_prediction.CreatePredictionOutputBoundary;
import use_case.fetch_predictions.FetchPredictionsInputBoundary;
import use_case.fetch_predictions.FetchPredictionsInteractor;
import use_case.fetch_predictions.FetchPredictionsOutputBoundary;
import view.CreatePredictionView;
import view.DashboardView;
import view.SignupView;
import interface_adapter.signup.SignupController;
import use_case.signup.SignupInputBoundary;
import use_case.signup.SignupInteractor;
import view.ViewManager;

import java.awt.*;

public class AppBuilder {

    private final JPanel mainWindow = new JPanel();
    private final CardLayout mainLayout = new CardLayout();
    final PredictionFactory predictionFactory = new PredictionFactory();
    final ViewManagerModel viewManagerModel = new ViewManagerModel();
    ViewManager viewManager = new ViewManager(mainWindow, mainLayout, viewManagerModel);




    final CreatePredictionDataAccessInterface dataAccessObject = new CreatePredictionDataAccessInterface() {


        @Override
        public boolean existsByTitle(String title) {
            return false;
        }

        @Override
        public void save(Prediction prediction) {

        }
    };


    private CreatePredictionView createPredictionView;
    private CreatePredictionViewModel createPredictionViewModel;
    private DashboardView dashboardView;
    private DashboardViewModel dashboardViewModel;



    public AppBuilder(){ mainWindow.setLayout(mainLayout); }



    public AppBuilder addDashboardView(){
        dashboardViewModel = new DashboardViewModel();
        dashboardView = new DashboardView(dashboardViewModel, viewManagerModel);
        mainWindow.add(dashboardView, "dashboard view");

        return this;
    }
    public AppBuilder addCreatePredictionView(){
        createPredictionViewModel = new CreatePredictionViewModel();
        createPredictionView = new CreatePredictionView(createPredictionViewModel);
        mainWindow.add(createPredictionView, "prediction view");
        return this;
    }

    public AppBuilder addSignupView(){
        return this;
    }


    public AppBuilder addCreatePredictionUseCase(){
        final CreatePredictionOutputBoundary createPredictionOutputBoundary =
                new CreatePredictionPresenter(createPredictionViewModel);
        final CreatePredictionInputBoundary createPredictionInteractor =
                new CreatePredictionInteractor(predictionFactory, createPredictionOutputBoundary,dataAccessObject);
        CreatePredictionController controller = new CreatePredictionController(createPredictionInteractor);
        createPredictionView.setCreatePredictionController(controller);
        return this;
    }

    public AppBuilder addFetchPredictionsUseCase(){
        final FetchPredictionsOutputBoundary fetchPredictionsOutputBoundary =
                new DashboardPresenter(dashboardViewModel);
        final FetchPredictionsInputBoundary fetchPredictionsInteractor =
                new FetchPredictionsInteractor(fetchPredictionsOutputBoundary);
        DashboardController controller = new DashboardController(fetchPredictionsInteractor);
        dashboardView.setDashboardController(controller);
        return this;
    }

    public JFrame startup() {
        final JFrame application = new JFrame("UofT Polymarket");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        application.add(mainWindow);

        viewManagerModel.setView("dashboard view");
        viewManagerModel.notifyViewChanged();

        application.setSize(550, 400);
        application.setLocation(0,0);
        //application.setLocationRelativeTo(null);
        return application;
    }
}
