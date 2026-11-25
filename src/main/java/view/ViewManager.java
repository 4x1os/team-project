package view;

import interface_adapter.ViewManagerModel;
import interface_adapter.ViewManagerModelListener;

import javax.swing.*;
import java.awt.*;

public class ViewManager implements ViewManagerModelListener {
    private final CardLayout cardLayout;
    private final JPanel views;
    private final ViewManagerModel viewManagerModel;

    public ViewManager(JPanel views, CardLayout cardLayout, ViewManagerModel viewManagerModel){
        this.cardLayout = cardLayout;
        this.views = views;
        this.viewManagerModel = viewManagerModel;
        this.viewManagerModel.setListener(this);
    }

    @Override
    public void viewChanged(){
        cardLayout.show(views, viewManagerModel.getViewName());
    }
}
