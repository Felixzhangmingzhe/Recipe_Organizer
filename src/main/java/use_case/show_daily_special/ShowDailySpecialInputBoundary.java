package use_case.show_daily_special;

import org.json.JSONException;

import java.io.IOException;

public interface ShowDailySpecialInputBoundary {
    void execute() throws IOException, JSONException;
}
