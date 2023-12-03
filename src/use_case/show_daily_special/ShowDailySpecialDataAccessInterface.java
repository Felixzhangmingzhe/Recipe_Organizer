package use_case.show_daily_special;

import entity.Recipe;

import java.io.IOException;

public interface ShowDailySpecialDataAccessInterface {
    public Recipe getDailySpecial() throws IOException;
}
