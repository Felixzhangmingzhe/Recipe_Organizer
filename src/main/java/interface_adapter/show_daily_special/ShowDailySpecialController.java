package interface_adapter.show_daily_special;

import org.json.JSONException;
import use_case.show_daily_special.ShowDailySpecialInputBoundary;

import java.io.IOException;

public class ShowDailySpecialController {

    final ShowDailySpecialInputBoundary showDailySpecialInteractor;

    public ShowDailySpecialController(ShowDailySpecialInputBoundary showDailySpecialInteractor) {
        this.showDailySpecialInteractor = showDailySpecialInteractor;
    }

    public void execute() throws IOException, JSONException {
        showDailySpecialInteractor.execute();
    }
}