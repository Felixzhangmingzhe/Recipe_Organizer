package app;

import data_access.FileRecipeDataAccessObject;

import entity.Recipe;
import entity.RecipeFactory;

import java.io.IOException;
import java.time.LocalDateTime;

public class RecipePresetter implements DataPresetter{
    private final RecipeFactory recipeFactory;
    RecipePresetter() {
        this.recipeFactory = new RecipeFactory();
    }
    public void presetData(FileRecipeDataAccessObject DAO) {
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
        if (!DAO.existsJudgingbyId(newRecipe.getId())){
            DAO.addRecipe(newRecipe);}

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
        if (!DAO.existsJudgingbyId(pastaRecipe.getId())){
            DAO.addRecipe(pastaRecipe);}

        Recipe saladRecipe = recipeFactory.create(
                3,
                "Caesar Salad",
                "Chop lettuce. Add croutons, parmesan, and dressing. Toss well.",
                date,
                true,
                800,
                false
        );
        if (!DAO.existsJudgingbyId(saladRecipe.getId())) {
            DAO.addRecipe(saladRecipe);}

        Recipe pizzaRecipe = recipeFactory.create(
                4,
                "Pizza Margherita",
                "Make dough. Add tomato sauce and cheese. Bake until crispy.",
                date,
                false,
                1500,
                false
        );
        if (!DAO.existsJudgingbyId(pizzaRecipe.getId())) {
            DAO.addRecipe(pizzaRecipe);}

        Recipe soupRecipe = recipeFactory.create(
                5,
                "Tomato Soup",
                "Chop tomatoes. Boil them. Add salt and pepper.",
                date,
                false,
                600,
                false
        );
        if (!DAO.existsJudgingbyId(soupRecipe.getId())) {
            DAO.addRecipe(soupRecipe);}

        Recipe steakRecipe = recipeFactory.create(
                6,
                "Steak",
                "Season steak. Grill it until medium rare.",
                date,
                false,
                2000,
                false
        );
        if (!DAO.existsJudgingbyId(steakRecipe.getId())) {
            DAO.addRecipe(steakRecipe);}

        Recipe chickenRecipe = recipeFactory.create(
                7,
                "Roast Chicken",
                "Season chicken. Roast it until cooked.",
                date,
                false,
                1500,
                false
        );
        if (!DAO.existsJudgingbyId(chickenRecipe.getId())) {
            DAO.addRecipe(chickenRecipe);}

        Recipe cakeRecipe = recipeFactory.create(
                8,
                "Chocolate Cake",
                "Mix flour, eggs, and chocolate. Bake until cooked.",
                date,
                false,
                2000,
                false
        );
        if (!DAO.existsJudgingbyId(cakeRecipe.getId())) {
            DAO.addRecipe(cakeRecipe);}

        Recipe cookieRecipe = recipeFactory.create(
                9,
                "Chocolate Chip Cookies",
                "Mix flour, eggs, and chocolate chips. Bake until cooked.",
                date,
                false,
                1500,
                false
        );
        if (!DAO.existsJudgingbyId(cookieRecipe.getId())) {
            DAO.addRecipe(cookieRecipe);}

        Recipe iceCreamRecipe = recipeFactory.create(
                10,
                "Vanilla Ice Cream",
                "Mix cream, sugar, and vanilla. Freeze until solid.",
                date,
                false,
                1000,
                false
        );
        if (!DAO.existsJudgingbyId(iceCreamRecipe.getId())) {
            DAO.addRecipe(iceCreamRecipe);}

        Recipe sushiRecipe = recipeFactory.create(
                11,
                "Sushi",
                "Cook rice. Add fish and vegetables. Roll them together.",
                date,
                false,
                1000,
                false
        );
        if (!DAO.existsJudgingbyId(sushiRecipe.getId())) {
            DAO.addRecipe(sushiRecipe);}

        Recipe ramenRecipe = recipeFactory.create(
                12,
                "Ramen",
                "Boil broth. Add noodles, egg, and pork. Cook until noodles are done.",
                date,
                false,
                1200,
                false
        );
        if (!DAO.existsJudgingbyId(ramenRecipe.getId())) {
            DAO.addRecipe(ramenRecipe);}
    }

    @Override
    public void presetDataOutside(FileRecipeDataAccessObject DAO, int numberOfObject) throws IOException {
        LocalDateTime date = LocalDateTime.of(2021, 1, 1, 0, 0, 0);
        setRecipesFromAPI(DAO, numberOfObject);
    }

    // @Override
    // public void prepareData(FileRecipeDataAccessObject DAO, List<Object> data) {
    //     for (Object obj : data) {
    //         if (obj instanceof Recipe) {
    //             Recipe recipe = (Recipe) obj;
    //             if (!DAO.existsJudgingbyId(recipe.getId())) {
    //                 DAO.addRecipe(recipe);
    //             }
    //         }
    //     }
    // }

    public void setRecipesFromAPI(FileRecipeDataAccessObject DAO, int numOfRecipes) throws IOException {
        DAO.saveRecipesFromAPIByNum(numOfRecipes);
    }
}
