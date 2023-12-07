package use_case.edit_recipe;

import entity.Recipe;
import org.json.JSONException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.edit_recipe.EditRecipeDataAccessInterface;
import use_case.edit_recipe.EditRecipeInputData;
import use_case.edit_recipe.EditRecipeInteractor;
import use_case.edit_recipe.EditRecipeOutputBoundary;
import use_case.edit_recipe.EditRecipeOutputData;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EditRecipeInteractorTest {
    private EditRecipeDataAccessInterface userDataAccess;
    private EditRecipeOutputBoundary presenter;
    private EditRecipeInteractor interactor;

    @BeforeEach
    void setUp() {
        userDataAccess = mock(EditRecipeDataAccessInterface.class);
        presenter = mock(EditRecipeOutputBoundary.class);
        interactor = new EditRecipeInteractor(userDataAccess, presenter);
    }

    @Test
    void testExecute() throws JSONException {
        // 创建输入数据
        EditRecipeInputData inputData = new EditRecipeInputData("Original Title", "New Title", "New Content");

        // 创建模拟的Recipe对象
        Recipe originalRecipe = new Recipe(1, "Original Title", "Original Content", LocalDateTime.now(), false, false, 300.0);

        // 模拟数据访问层的方法调用
        when(userDataAccess.getRecipeByTitle("Original Title")).thenReturn(originalRecipe);

        // 执行use case
        interactor.execute(inputData);

        // 验证数据访问层方法是否被调用
        verify(userDataAccess, times(1)).getRecipeByTitle("Original Title");
        verify(userDataAccess, times(1)).updateRecipe(eq(1), eq("New Title"), eq("New Content"), any(LocalDateTime.class), eq(false), eq(false), eq(300.0));

        // 验证输出界面方法是否被调用
        verify(presenter, times(1)).prepareSuccessView(any(EditRecipeOutputData.class));
    }
}
