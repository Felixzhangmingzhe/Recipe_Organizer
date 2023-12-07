package interface_adapter.click_search;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import use_case.click_search.ClickSearchInputBoundary;
import use_case.click_search.ClickSearchInputData;

import java.io.IOException;

import static org.mockito.Mockito.*;

class ClickSearchControllerTest {

    @Mock
    private ClickSearchInputBoundary clickSearchInteractor;

    private ClickSearchController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        controller = new ClickSearchController(clickSearchInteractor);
    }

    @Test
    void execute() throws IOException {
        String searchQuery = "test query";
        controller.execute(searchQuery);

        verify(clickSearchInteractor, times(1)).clickSearch(any(ClickSearchInputData.class));
    }

    @Test
    void execute_withIOException() throws IOException {
        String searchQuery = "test query";
        doThrow(new IOException("Test IOException")).when(clickSearchInteractor).clickSearch(any(ClickSearchInputData.class));

        controller.execute(searchQuery);

        verify(clickSearchInteractor, times(1)).clickSearch(any(ClickSearchInputData.class));
        // Additional verification for error handling can be added here if applicable
    }
}
