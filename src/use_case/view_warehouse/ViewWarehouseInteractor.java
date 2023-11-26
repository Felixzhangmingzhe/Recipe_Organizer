package use_case.view_warehouse;
import entity.Recipe;
import interface_adapter.view_warehouse.*;


import java.util.List;

public class ViewWarehouseInteractor implements ViewWarehouseInputBoundary{
    private ViewWarehousePresenter viewWarehousePresenter;
    private ViewWarehouseDataAccessInterface viewWarehouseDataAccessInterface;
    @Override
    public void execute() {//当没有recipe时，是另外prepareFailure,还是直接返回空的list，然后显示空的list
        List<Recipe> resipes = viewWarehouseDataAccessInterface.getAllRecipe();
        ViewWarehouseOutputData viewWarehouseOutputData = new ViewWarehouseOutputData(resipes);
        viewWarehousePresenter.prepareSuccess(viewWarehouseOutputData);
    }
}
