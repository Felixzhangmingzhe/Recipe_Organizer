package use_case.create_recipe;

import entity.Recipe;
import entity.RecipeFactory;

import org.json.JSONException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;

import java.io.IOException;
import java.time.LocalDateTime;

import static org.mockito.Mockito.*;

public class CreateRecipeInteractorTest {

    @Mock
    private CreateRecipeUserDataAccessInterface mockDataAccessInterface;

    @Mock
    private CreateRecipeOutputBoundary mockPresenter;

    @Mock
    private RecipeFactory mockRecipeFactory;

    @InjectMocks
    private CreateRecipeInteractor interactor;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testExecute_TitleIsEmpty() throws IOException, JSONException {
        CreateRecipeInputData inputData = new CreateRecipeInputData("", "Recipe Content");
        interactor.execute(inputData);
        verify(mockPresenter, times(1)).prepareFailView("Title is empty");
        verifyNoMoreInteractions(mockDataAccessInterface, mockRecipeFactory, mockPresenter);
    }

    @Test
    public void testExecute_ContentIsEmpty() throws IOException, JSONException {
        when(mockDataAccessInterface.existsByName(anyString())).thenReturn(false);
        CreateRecipeInputData inputData = new CreateRecipeInputData("Recipe Title", "");
        interactor.execute(inputData);
        verify(mockPresenter, times(1)).prepareFailView("Content is empty");
        verifyNoMoreInteractions(mockDataAccessInterface, mockRecipeFactory, mockPresenter);
    }

    @Test
    public void testExecute_RecipeAlreadyExists() throws IOException, JSONException {
        when(mockDataAccessInterface.existsByName(anyString())).thenReturn(true);
        CreateRecipeInputData inputData = new CreateRecipeInputData("Recipe Title", "Recipe Content");
        interactor.execute(inputData);
        verify(mockPresenter, times(1)).prepareFailView("Recipe already exists");
        verifyNoMoreInteractions(mockDataAccessInterface, mockRecipeFactory, mockPresenter);
    }

    @Test
    public void testExecute_Success() throws IOException, JSONException {
        when(mockDataAccessInterface.existsByName(anyString())).thenReturn(false);
        when(mockRecipeFactory.create(anyInt(), anyString(), anyString(), any(LocalDateTime.class), anyBoolean(), anyDouble(), anyBoolean()))
                .thenReturn(new Recipe(1, "Recipe Title", "Recipe Content", LocalDateTime.now(), false, false, 100.0));

        CreateRecipeInputData inputData = new CreateRecipeInputData("Recipe Title", "Recipe Content");
        interactor.execute(inputData);

        verify(mockDataAccessInterface, times(1)).save(any(Recipe.class));
        verify(mockPresenter, times(1)).prepareSuccessView(any(CreateRecipeOutputData.class));
        verifyNoMoreInteractions(mockDataAccessInterface, mockRecipeFactory, mockPresenter);
    }

    @Test
    public void testExecute_FetchCaloriesError() throws IOException, JSONException {
        when(mockDataAccessInterface.existsByName(anyString())).thenReturn(false);
        when(mockRecipeFactory.create(anyInt(), anyString(), anyString(), any(LocalDateTime.class), anyBoolean(), anyDouble(), anyBoolean()))
                .thenReturn(new Recipe(1, "Recipe Title", "Recipe Content", LocalDateTime.now(), false,false,-1.0));

        // Simulate an error during calorie fetching
        when(mockDataAccessInterface.getLastUsedRecipeIdFromDatabase()).thenReturn(0);
        when(mockDataAccessInterface.existsByName(anyString())).thenReturn(false);

        // Mock the static method to throw an IOException
        PowerMockito.mockStatic(CreateRecipeInteractor.class);
        when(CreateRecipeInteractor.fetchCaloriesData(anyString())).thenThrow(new IOException("Error fetching calories"));

        CreateRecipeInputData inputData = new CreateRecipeInputData("Recipe Title", "Recipe Content");
        interactor.execute(inputData);

        verify(mockPresenter, times(1)).prepareFailView("Error fetching calories");
        verifyNoMoreInteractions(mockDataAccessInterface, mockRecipeFactory, mockPresenter);
    }
}
