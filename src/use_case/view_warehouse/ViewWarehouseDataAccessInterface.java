package use_case.view_warehouse;
import entity.Recipe;
import java.util.List;

public interface ViewWarehouseDataAccessInterface {
    List<Recipe> getAllRecipe();
}
