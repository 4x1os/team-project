package interface_adapter;



public class ViewManagerModel {
    // Sets the default view to the signup page when application starts
    private ViewState state = ViewState.SIGNUP;
    private ViewManagerModelListener listener;
    public ViewManagerModel(ViewManagerModelListener listener) {
        this.listener = listener;


    }
    /**
     * Get current state
     * @return current view state
     */
    public ViewState getState () {
        return state;
    }

    /**
     * Updates current state
     * @param state new view state
     */
    public void setState (ViewState state) {
        this.state = state;
    }
}
