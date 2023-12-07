package use_case.show_daily_special;

import entity.Recipe;

import java.io.IOException;

public class ShowDailySpecialInteractor implements ShowDailySpecialInputBoundary{
    private ShowDailySpecialOutputBoundary showDailySpecialPresenter;
    private ShowDailySpecialDataAccessInterface showDailySpecialDataAccessInterface;

    public ShowDailySpecialInteractor(
            ShowDailySpecialOutputBoundary showDailySpecialPresenter,
            ShowDailySpecialDataAccessInterface showDailySpecialDataAccessInterface) {
        this.showDailySpecialPresenter = showDailySpecialPresenter;
        this.showDailySpecialDataAccessInterface = showDailySpecialDataAccessInterface;
    }

    public void execute() throws IOException {
        Recipe dailySpecial = showDailySpecialDataAccessInterface.getDailySpecial();
        ShowDailySpecialOutputData showDailySpecialOutputData = new ShowDailySpecialOutputData(dailySpecial);
//        System.out.println("Daily special is " + dailySpecial.getTitle());
        showDailySpecialPresenter.prepareSuccessView(showDailySpecialOutputData);
    }

}