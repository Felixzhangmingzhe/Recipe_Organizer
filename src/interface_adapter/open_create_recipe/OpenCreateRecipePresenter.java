package interface_adapter.open_create_recipe;

import interface_adapter.ViewManagerModel;
import use_case.open_create_recipe.OpenCreateRecipeOutputBoundary;

public class OpenCreateRecipePresenter implements OpenCreateRecipeOutputBoundary {
    private OpenCreateRecipeViewModel openCreateRecipeViewModel;
    private ViewManagerModel viewManagerModel;

    public OpenCreateRecipePresenter(OpenCreateRecipeViewModel openCreateRecipeViewModel, ViewManagerModel viewManagerModel) {
        this.openCreateRecipeViewModel = openCreateRecipeViewModel;
        this.viewManagerModel = viewManagerModel;
    }
    @Override
    public void prepareSuccessView() {
        openCreateRecipeViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(openCreateRecipeViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
        // MainView 添加监听器，监听 viewManagerModel 的变化，变化后调用 viewManagerModel.getActiveView() 获取当前活跃的 view，然后根据 view 的名字显示对应的 view
    }
}
