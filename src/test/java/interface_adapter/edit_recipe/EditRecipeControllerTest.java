package interface_adapter.edit_recipe;

import use_case.edit_recipe.EditRecipeInputBoundary;
import use_case.edit_recipe.EditRecipeInputData;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EditRecipeControllerTest {

    @Test
    void testExecute() throws Exception {
        // 创建Mock对象
        EditRecipeInputBoundary interactor = mock(EditRecipeInputBoundary.class);
        EditRecipeController controller = new EditRecipeController(interactor);

        // 设置输入参数
        String originalTitle = "Original Title";
        String newTitle = "New Title";
        String newContent = "New Content";

        // 执行Controller的execute方法
        controller.execute(originalTitle, newTitle, newContent);

        // 验证Interactor的execute方法是否被调用，并捕获参数
        ArgumentCaptor<EditRecipeInputData> captor = ArgumentCaptor.forClass(EditRecipeInputData.class);
        verify(interactor, times(1)).execute(captor.capture());

        // 验证输入参数是否正确传递给Interactor
        EditRecipeInputData inputData = captor.getValue();
        assertEquals(originalTitle, inputData.getOriginalRecipeTiltle());
        assertEquals(newTitle, inputData.getTitle());
        assertEquals(newContent, inputData.getContent());
    }
}
