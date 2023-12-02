package interface_adapter.show_daily_special;

import use_case.show_daily_special.ShowDailySpecialInputBoundary;

public class ShowDailySpecialController {

    final ShowDailySpecialInputBoundary showDailySpecialInteractor;

    public ShowDailySpecialController(ShowDailySpecialInputBoundary showDailySpecialInteractor) {
        this.showDailySpecialInteractor = showDailySpecialInteractor;
    }

    public void execute() {
        showDailySpecialInteractor.execute();
    }
}
