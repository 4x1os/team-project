package interface_adapter.dashboard;

public class DashboardViewModel {

    private DashboardState state = new DashboardState();

    public DashboardState getState(){
        return this.state;
    }

    public void setState(DashboardState state){
        this.state = state;
    }
}
