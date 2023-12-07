package interface_adapter.view_warehouse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import use_case.view_warehouse.ViewWarehouseInputBoundary;

import static org.mockito.Mockito.*;

class ViewWarehouseControllerTest {

    @Mock
    private ViewWarehouseInputBoundary mockInteractor;

    private ViewWarehouseController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        controller = new ViewWarehouseController(mockInteractor);
    }

    @Test
    void execute_CallsInteractorExecute() {
        controller.execute();

        // Verify that execute is called on the interactor
        verify(mockInteractor, times(1)).execute();
    }
}
