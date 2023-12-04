package use_case.export;

import entity.Recipe;

import java.util.List;

public interface exportDataAccessInterface {
    List<Recipe> getRecipes();
}
