package interface_adapter.dashboard;

import java.util.ArrayList;

public class DashboardState {
    private ArrayList<Object> list = new ArrayList<Object>();

    public ArrayList<Object> getPredictions() { return list; }

    public void setPredictions(ArrayList<Object> list) { this.list = list; }
}
