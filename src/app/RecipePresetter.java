package app;

import data_access.FileRecipeDataAccessObject;
import entity.Recipe;
import entity.RecipeFactory;

import java.time.LocalDateTime;

public class RecipePresetter implements DataPresetter{
    private RecipeFactory recipeFactory;
    RecipePresetter() {
        this.recipeFactory = new RecipeFactory();
    }
    public void presetData(FileRecipeDataAccessObject dao) {
        LocalDateTime date = LocalDateTime.of(2021, 1, 1, 0, 0, 0);

        // Adding a recipe
        Recipe newRecipe = recipeFactory.create(
                1,
                "Spaghetti Bolognese",
                "Cook the spaghetti. Cook the ground beef. Mix them together.",
                date,
                false,
                1000,
                false
        );
        if (!dao.existsJudgingbyId(newRecipe.getId())){dao.addRecipe(newRecipe);}

        // Adding more recipes for pre-setting data
        Recipe pastaRecipe = recipeFactory.create(
                2,
                "Pasta Carbonara",
                "Boil the pasta. Mix eggs, cheese, and bacon. Combine with pasta.",
                date,
                false,
                1200,
                false
        );
        if (!dao.existsJudgingbyId(pastaRecipe.getId())){dao.addRecipe(pastaRecipe);}

        Recipe saladRecipe = recipeFactory.create(
                3,
                "Caesar Salad",
                "Chop lettuce. Add croutons, parmesan, and dressing. Toss well.",
                date,
                true,
                800,
                false
        );
        if (!dao.existsJudgingbyId(saladRecipe.getId())) {dao.addRecipe(saladRecipe);}
    }
    // 这里可以使用api来获取一些网络上的菜谱，然后添加到数据库中
}
