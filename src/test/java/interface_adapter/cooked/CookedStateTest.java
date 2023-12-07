package interface_adapter.cooked;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CookedStateTest {

    @Test
    void setSetCookedSuccess() {
        CookedState state = new CookedState();
        state.setSetCookedSuccess(true);

        assertTrue(state.getSetCookedSuccess(), "setSetCookedSuccess should correctly set the state to true.");
    }

    @Test
    void getSetCookedSuccess() {
        CookedState state = new CookedState();
        state.setSetCookedSuccess(false);

        assertFalse(state.getSetCookedSuccess(), "getSetCookedSuccess should return the correct state.");
    }
}
