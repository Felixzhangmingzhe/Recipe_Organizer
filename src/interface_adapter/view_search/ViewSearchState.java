package interface_adapter.view_search;

public class ViewSearchState {

    private String searchQuery;

    public ViewSearchState(String searchQuery) {
        this.searchQuery = searchQuery;
    }

    public ViewSearchState() {
    }

    public String getSearchQuery() {
        return searchQuery;
    }

    public void setSearchQuery(String searchQuery) {
        this.searchQuery = searchQuery;
    }
}