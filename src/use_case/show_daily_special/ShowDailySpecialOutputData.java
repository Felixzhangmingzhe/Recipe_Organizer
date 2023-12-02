package use_case.show_daily_special;

import entity.Recipe;

public class ShowDailySpecialOutputData {
    private final Recipe dailySpecialRecipe;

    public ShowDailySpecialOutputData(Recipe dailySpecialRecipe) {
        this.dailySpecialRecipe = dailySpecialRecipe;
    }

    public Recipe getDailySpecialRecipe() {
        return dailySpecialRecipe;
    }
}
