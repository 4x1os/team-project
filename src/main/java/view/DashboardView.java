package view;

import interface_adapter.dashboard.DashboardState;
import interface_adapter.dashboard.DashboardViewModel;
import interface_adapter.dashboard.DashboardViewModelListener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DashboardView extends JPanel implements ActionListener, DashboardViewModelListener {

    private final DashboardViewModel dashboardViewModel;
    private final JPanel board = new JPanel();

    public DashboardView(DashboardViewModel dashboardViewModel){
        this.dashboardViewModel = dashboardViewModel;

        final JLabel title = new JLabel("Dashboard");
        board.add(title);


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
}
