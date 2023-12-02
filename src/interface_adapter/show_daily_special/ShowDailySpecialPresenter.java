package interface_adapter.show_daily_special;

import interface_adapter.ViewManagerModel;
import use_case.show_daily_special.ShowDailySpecialOutputBoundary;
import use_case.show_daily_special.ShowDailySpecialOutputData;

public class ShowDailySpecialPresenter implements ShowDailySpecialOutputBoundary {

    private final ShowDailySpecialViewModel showDailySpecialViewModel;
    private final ViewManagerModel viewManagerModel;

    public ShowDailySpecialPresenter(ShowDailySpecialViewModel showDailySpecialViewModel, ViewManagerModel viewManagerModel) {
        this.showDailySpecialViewModel = showDailySpecialViewModel;
        this.viewManagerModel = viewManagerModel;
    }


    @Override
    public void prepareSuccessView(ShowDailySpecialOutputData showDailySpecialOutputData) {
        ShowDailySpecialState state = new ShowDailySpecialState();
//        System.out.println(showDailySpecialOutputData.getDailySpecialRecipe().getTitle());//看看有没有拿到数据-有
        state.setTitle(showDailySpecialOutputData.getDailySpecialRecipe().getTitle());
        state.setContent(showDailySpecialOutputData.getDailySpecialRecipe().getContent());
        state.setCreationTime(showDailySpecialOutputData.getDailySpecialRecipe().getDate());
        state.setCalories(showDailySpecialOutputData.getDailySpecialRecipe().getCalories());
        this.showDailySpecialViewModel.setState(state);

        showDailySpecialViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(showDailySpecialViewModel.getViewName());
        viewManagerModel.firePropertyChanged();// this evt is state.
//        System.out.println(state.getContent());
        System.out.println("Daily special is " + showDailySpecialOutputData.getDailySpecialRecipe().getTitle());
    }
}
