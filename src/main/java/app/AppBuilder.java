package app;

import javax.swing.*;
// WILL HAVE TO EVENTUALLY REPLACE application.add(signupView); with viewManager
import entity.Prediction;
import entity.PredictionFactory;
import interface_adapter.create_prediction.CreatePredictionController;
import interface_adapter.create_prediction.CreatePredictionPresenter;
import interface_adapter.create_prediction.CreatePredictionViewModel;
import interface_adapter.dashboard.DashboardViewModel;
import use_case.create_prediction.CreatePredictionDataAccessInterface;
import use_case.create_prediction.CreatePredictionInputBoundary;
import use_case.create_prediction.CreatePredictionInteractor;
import use_case.create_prediction.CreatePredictionOutputBoundary;
import view.CreatePredictionView;
import view.DashboardView;
import view.SignupView;
import interface_adapter.signup.SignupController;
import use_case.signup.SignupInputBoundary;
import use_case.signup.SignupInteractor;

public class AppBuilder {

    private CreatePredictionView createPredictionView;
    private CreatePredictionViewModel createPredictionViewModel;
    final PredictionFactory predictionFactory = new PredictionFactory();
    final CreatePredictionDataAccessInterface dataAccessObject = new CreatePredictionDataAccessInterface() {
        @Override
        public boolean existsByTitle(String title) {
            return false;
        }

        @Override
        public void save(Prediction prediction) {

        }
    };


    public JFrame startup() {
        final JFrame application = new JFrame("UofT Polymarket - Sign up");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        /*
        // Creates sign up interactor, controller to the interactor, view to the controller
        SignupInteractor signupInteractor = new SignupInteractor();
        SignupController signupController = new SignupController(signupInteractor);
        SignupView signupView = new SignupView(signupController);

        application.add(signupView);
*/


        createPredictionViewModel = new CreatePredictionViewModel();
        createPredictionView = new CreatePredictionView(createPredictionViewModel);
        final CreatePredictionOutputBoundary createPredictionOutputBoundary =
                new CreatePredictionPresenter(createPredictionViewModel);
        final CreatePredictionInputBoundary createPredictionInteractor =
                new CreatePredictionInteractor(predictionFactory, createPredictionOutputBoundary,dataAccessObject);
        CreatePredictionController controller = new CreatePredictionController(createPredictionInteractor);
        createPredictionView.setCreatePredictionController(controller);

        application.add(createPredictionView);

        application.setSize(550, 250);
        application.setLocation(0,0);
        //application.setLocationRelativeTo(null);
        return application;
    }
}
