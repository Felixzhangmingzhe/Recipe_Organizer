package use_case.show_daily_special;

import entity.Recipe;

public class ShowDailySpecialInteractor {
    private ShowDailySpecialOutputBoundary showDailySpecialPresenter;
    private ShowDailySpecialDataAccessInterface showDailySpecialDataAccessInterface;

    public ShowDailySpecialInteractor(
            ShowDailySpecialOutputBoundary showDailySpecialPresenter,
            ShowDailySpecialDataAccessInterface showDailySpecialDataAccessInterface) {
        this.showDailySpecialPresenter = showDailySpecialPresenter;
        this.showDailySpecialDataAccessInterface = showDailySpecialDataAccessInterface;
    }

    public void execute() {
        Recipe dailySpecial = showDailySpecialDataAccessInterface.getDailySpecial();
        ShowDailySpecialOutputData showDailySpecialOutputData = new ShowDailySpecialOutputData(dailySpecial);
        showDailySpecialPresenter.prepareSuccessView(showDailySpecialOutputData);
    }

}
