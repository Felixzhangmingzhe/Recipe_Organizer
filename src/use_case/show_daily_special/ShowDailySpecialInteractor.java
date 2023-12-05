package use_case.show_daily_special;

import entity.Recipe;

import java.io.IOException;

public class ShowDailySpecialInteractor implements ShowDailySpecialInputBoundary{
    // Data access interface and presenter
    private final ShowDailySpecialDataAccessInterface showDailySpecialDataAccessInterface;
    private final ShowDailySpecialOutputBoundary showDailySpecialPresenter;

    // Constructor
    public ShowDailySpecialInteractor(ShowDailySpecialOutputBoundary showDailySpecialPresenter, ShowDailySpecialDataAccessInterface showDailySpecialDataAccessInterface) {
        this.showDailySpecialDataAccessInterface = showDailySpecialDataAccessInterface;
        this.showDailySpecialPresenter = showDailySpecialPresenter;
    }

    // Implementation of execute method in Input Boundary
    public void execute() throws IOException {
        // Retrieve daily special
        Recipe dailySpecial = showDailySpecialDataAccessInterface.getDailySpecial();
        // Output data indicating switching to daily special
        ShowDailySpecialOutputData showDailySpecialOutputData = new ShowDailySpecialOutputData(dailySpecial);
//        System.out.println("Daily special is " + dailySpecial.getTitle());
        showDailySpecialPresenter.prepareSuccessView(showDailySpecialOutputData);
    }

}