package app;

import data_access.FileRecipeDataAccessObject;
import interface_adapter.Back.BackViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.create_recipe.CreateRecipeViewModel;
import interface_adapter.edit_recipe.EditRecipeController;
import interface_adapter.edit_recipe.EditRecipeViewModel;
import interface_adapter.jump_to_edit.JumpToEditViewModel;
import interface_adapter.open_create_recipe.OpenCreateRecipeViewModel;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import view.EditRecipeView;

import static org.mockito.Mockito.*;


public class EditRecipeViewUseCaseFactoryTest {

    @Test
    public void testCreateEditRecipeView() throws JSONException {
        // 创建所需的模拟对象
        BackViewModel backViewModelMock = mock(BackViewModel.class);
        ViewManagerModel viewManagerModelMock = mock(ViewManagerModel.class);
        CreateRecipeViewModel createRecipeViewModelMock = mock(CreateRecipeViewModel.class);
        OpenCreateRecipeViewModel openCreateRecipeViewModelMock = mock(OpenCreateRecipeViewModel.class);
        EditRecipeViewModel editRecipeViewModelMock = mock(EditRecipeViewModel.class);
        JumpToEditViewModel jumpToEditViewModelMock = mock(JumpToEditViewModel.class);
        FileRecipeDataAccessObject daoMock = mock(FileRecipeDataAccessObject.class);

        // 创建被测试的对象
        EditRecipeView editRecipeView = EditRecipeViewUseCaseFactory.create(
                backViewModelMock, viewManagerModelMock, createRecipeViewModelMock,
                openCreateRecipeViewModelMock, editRecipeViewModelMock,
                jumpToEditViewModelMock, daoMock
        );

        // 验证被测试对象的方法调用

        // 模拟 EditRecipeController 的测试
        EditRecipeController editRecipeControllerMock = mock(EditRecipeController.class);

        // 验证 EditRecipeController 的方法调用
        verify(editRecipeControllerMock, times(1)).execute(any(), any(), any());

        // 添加更多测试用例以覆盖其他情况
    }
}
