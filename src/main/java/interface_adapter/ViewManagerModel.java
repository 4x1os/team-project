package interface_adapter;



public class ViewManagerModel {

    private ViewManagerModelListener listener = null;
    private String currentViewName = "";


    public String getViewName() { return this.currentViewName; }

    public void setView(String newViewName) { this.currentViewName = newViewName; }

    public void notifyViewChanged() { listener.viewChanged(); }

    public void setListener(ViewManagerModelListener listener) { this.listener = listener; }



}
