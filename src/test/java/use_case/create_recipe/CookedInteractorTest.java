package use_case.create_recipe;

import entity.Recipe;

import use_case.cooked.CookedDataAccessInterface;
import use_case.cooked.CookedInputData;
import use_case.cooked.CookedInteractor;
import use_case.cooked.CookedOutputBoundary;
import use_case.cooked.CookedOutputData;

import static org.mockito.Mockito.*;

import org.json.JSONException;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class CookedInteractorTest {

    @Test
    public void testExecute_CookedRecipe() throws JSONException {
        // Create mock objects
        CookedOutputBoundary cookedPresenter = mock(CookedOutputBoundary.class);
        CookedDataAccessInterface cookedDataAccessInterface = mock(CookedDataAccessInterface.class);
        int id = mock(int.class);
        String title = mock(String.class);
        String content = mock(String.class);
        boolean isFavorite = mock(boolean.class);
        boolean isCooked = mock(boolean.class);
        double calories = mock(double.class);
        LocalDateTime date = mock(LocalDateTime.class);
        // Configure mock objects
        Recipe mockedRecipe = new Recipe(id, title, content, date, isFavorite, isCooked, calories);
        when(cookedDataAccessInterface.getRecipeByRecipeTitle(anyString())).thenReturn(mockedRecipe);

        // Create CookedInputData object
        CookedInputData inputData = new CookedInputData("MockedRecipeTitle");

        // Create CookedInteractor object
        CookedInteractor cookedInteractor = new CookedInteractor(cookedDataAccessInterface, cookedPresenter);

        // Call execute method
        cookedInteractor.execute(inputData);

        // Verify expected interactions
        verify(cookedDataAccessInterface, times(1)).getRecipeByRecipeTitle("MockedRecipeTitle");
        verify(cookedPresenter, times(1)).prepareFailView(any(CookedOutputData.class));
        verify(cookedDataAccessInterface, never()).updateCookedRecipe(any(), any(), any(), any(), anyBoolean(), anyBoolean(), anyInt());
        verify(cookedPresenter, never()).prepareSuccessView(any(CookedOutputData.class));
    }

    @Test
    public void testExecute_UncookedRecipe() throws JSONException {
        // 创建模拟对象
        CookedOutputBoundary cookedPresenter = mock(CookedOutputBoundary.class);
        CookedDataAccessInterface cookedDataAccessInterface = mock(CookedDataAccessInterface.class);

        // 设置模拟对象的行为
        int id = mock(int.class);
        String title = mock(String.class);
        String content = mock(String.class);
        boolean isFavorite = mock(boolean.class);
        boolean isCooked = mock(boolean.class);
        double calories = mock(double.class);
        LocalDateTime date = mock(LocalDateTime.class);
        Recipe uncookedRecipe = new Recipe(id, title, content, date, isFavorite, isCooked, calories);
        when(cookedDataAccessInterface.getRecipeByRecipeTitle(anyString())).thenReturn(uncookedRecipe);

        // 创建CookedInputData对象
        CookedInputData inputData = new CookedInputData("MockedRecipeTitle");

        // 创建CookedInteractor对象
        CookedInteractor cookedInteractor = new CookedInteractor(cookedDataAccessInterface, cookedPresenter);

        // 调用execute方法
        cookedInteractor.execute(inputData);

        // 验证预期的交互是否发生
        verify(cookedDataAccessInterface, times(1)).getRecipeByRecipeTitle("MockedRecipeTitle");
        verify(cookedDataAccessInterface, times(1)).updateCookedRecipe(any(), any(), any(), any(), anyBoolean(), anyBoolean(), anyInt());
        verify(cookedPresenter, times(1)).prepareSuccessView(any(CookedOutputData.class));
        verify(cookedPresenter, never()).prepareFailView(any(CookedOutputData.class));
    }
}

// import entity.Recipe;
//import entity.RecipeFactory;
//import org.junit.jupiter.api.Test;
//import static org.mockito.Mockito.*;
//
//import java.io.IOException;
//import java.time.LocalDateTime;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//class CreateRecipeInteractorTest {
//
//    @Test
//    void execute_WhenTitleIsEmpty_ShouldPrepareFailView() {
//        // Arrange
//        CreateRecipeOutputBoundary mockPresenter = mock(CreateRecipeOutputBoundary.class);
//        CreateRecipeUserDataAccessInterface mockDataAccess = mock(CreateRecipeUserDataAccessInterface.class);
//        RecipeFactory mockRecipeFactory = mock(RecipeFactory.class);
//
//        CreateRecipeInteractor interactor = new CreateRecipeInteractor(mockPresenter, mockDataAccess, mockRecipeFactory);
//        CreateRecipeInputData inputData = new CreateRecipeInputData("", "Some content");
//
//        // Act
//        interactor.execute(inputData);
//
//        // Assert
//        verify(mockPresenter).prepareFailView("Title is empty");
//        verifyNoInteractions(mockDataAccess, mockRecipeFactory);
//    }
//
//    @Test
//    void execute_WhenContentIsEmpty_ShouldPrepareFailView() {
//        // Arrange
//        CreateRecipeOutputBoundary mockPresenter = mock(CreateRecipeOutputBoundary.class);
//        CreateRecipeUserDataAccessInterface mockDataAccess = mock(CreateRecipeUserDataAccessInterface.class);
//        RecipeFactory mockRecipeFactory = mock(RecipeFactory.class);
//
//        CreateRecipeInteractor interactor = new CreateRecipeInteractor(mockPresenter, mockDataAccess, mockRecipeFactory);
//        CreateRecipeInputData inputData = new CreateRecipeInputData("Some Title", "");
//
//        // Act
//        interactor.execute(inputData);
//
//        // Assert
//        verify(mockPresenter).prepareFailView("Content is empty");
//        verifyNoInteractions(mockDataAccess, mockRecipeFactory);
//    }
//
//    @Test
//    void execute_WhenRecipeExists_ShouldPrepareFailView() {
//        // Arrange
//        CreateRecipeOutputBoundary mockPresenter = mock(CreateRecipeOutputBoundary.class);
//        CreateRecipeUserDataAccessInterface mockDataAccess = mock(CreateRecipeUserDataAccessInterface.class);
//        RecipeFactory mockRecipeFactory = mock(RecipeFactory.class);
//
//        when(mockDataAccess.existsByName(anyString())).thenReturn(true);
//
//        CreateRecipeInteractor interactor = new CreateRecipeInteractor(mockPresenter, mockDataAccess, mockRecipeFactory);
//        CreateRecipeInputData inputData = new CreateRecipeInputData("Existing Recipe", "Some content");
//
//        // Act
//        interactor.execute(inputData);
//
//        // Assert
//        verify(mockPresenter).prepareFailView("Recipe already exists");
//        verify(mockDataAccess).existsByName("Existing Recipe");
//        verifyNoMoreInteractions(mockDataAccess, mockRecipeFactory);
//    }
//
//    @Test
//    void execute_WhenValidInput_ShouldSaveRecipeAndPrepareSuccessView() throws IOException {
//        // Arrange
//        CreateRecipeOutputBoundary mockPresenter = mock(CreateRecipeOutputBoundary.class);
//        CreateRecipeUserDataAccessInterface mockDataAccess = mock(CreateRecipeUserDataAccessInterface.class);
//        RecipeFactory mockRecipeFactory = mock(RecipeFactory.class);
//
//        when(mockDataAccess.existsByName(anyString())).thenReturn(false);
//        when(mockRecipeFactory.create(anyInt(), anyString(), anyString(), any(LocalDateTime.class), anyBoolean(), anyDouble(), anyBoolean())).thenReturn(new Recipe(1, "New Recipe", "Some content", LocalDateTime.now(), false,  false,200.0));
//
//        CreateRecipeInteractor interactor = new CreateRecipeInteractor(mockPresenter, mockDataAccess, mockRecipeFactory);
//        CreateRecipeInputData inputData = new CreateRecipeInputData("New Recipe", "Some content");
//
//        // Act
//        interactor.execute(inputData);
//
//        // Assert
//        verify(mockDataAccess).existsByName("New Recipe");
//        verify(mockRecipeFactory).create(anyInt(), eq("New Recipe"), eq("Some content"), any(LocalDateTime.class), eq(false), eq(200.0), eq(false));
//        verify(mockDataAccess).save(any(Recipe.class));
//        verify(mockPresenter).prepareSuccessView(any(CreateRecipeOutputData.class));
//        verifyNoMoreInteractions(mockDataAccess, mockRecipeFactory);
//    }
//}
