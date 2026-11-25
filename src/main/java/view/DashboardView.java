package view;

import interface_adapter.ViewManagerModel;
import interface_adapter.dashboard.DashboardController;
import interface_adapter.dashboard.DashboardState;
import interface_adapter.dashboard.DashboardViewModel;
import interface_adapter.dashboard.DashboardViewModelListener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DashboardView extends JPanel implements ActionListener, DashboardViewModelListener {

    private final DashboardViewModel dashboardViewModel;
    private final ViewManagerModel viewManagerModel;
    private final JPanel board = new JPanel();
    private DashboardController controller = null;
    private final JButton move;

    public DashboardView(DashboardViewModel dashboardViewModel, ViewManagerModel viewManagerModel){
        this.dashboardViewModel = dashboardViewModel;
        this.viewManagerModel = viewManagerModel;

        final JLabel title = new JLabel("Dashboard");

        move = new JButton("switch screen");

        move.addActionListener(e ->{
            this.viewManagerModel.setView("prediction view");
            this.viewManagerModel.notifyViewChanged();
        });

        board.add(title);
        board.add(move);

        this.add(board);
    }

    @Override
    public void stateChanged(){
        setFields(dashboardViewModel.getState());
    }

    private void setFields(DashboardState state){
        board.removeAll();
        for (Object i : state.getPredictions()){
            board.add(new JLabel("test"));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Click: " + e);
    }

    public void setDashboardController(DashboardController controller) { this.controller = controller; }
}
