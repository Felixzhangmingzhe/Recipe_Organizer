package interface_adapter.Back;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BackStateTest {

    @Test
    void setNumOfCooked() {
        int expectedNumOfCooked = 10;
        BackState state = new BackState();
        state.setNumOfCooked(expectedNumOfCooked);

        assertEquals(expectedNumOfCooked, state.getNumOfCooked(), "setNumOfCooked should correctly set the number of cooked items.");
    }

    @Test
    void getNumOfCooked() {
        int expectedNumOfCooked = 5;
        BackState state = new BackState();
        state.setNumOfCooked(expectedNumOfCooked);

        assertEquals(expectedNumOfCooked, state.getNumOfCooked(), "getNumOfCooked should return the correct number of cooked items.");
    }
}
