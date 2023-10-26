package src.entity;

public class Ingredient {
    private int id;
    private String ingredient_name;
    private String ingredient_type;
    Ingredient(int id, String ingredient_name, String ingredient_type) {
        this.id = id;
        this.ingredient_name = ingredient_name;
        this.ingredient_type = ingredient_type;
    }
}
