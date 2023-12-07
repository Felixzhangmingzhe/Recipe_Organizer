package use_case.Back;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BackOutputDataTest {

    @Test
    void getNumOfCooked() {
        int expectedNumOfCooked = 10;
        BackOutputData backOutputData = new BackOutputData(expectedNumOfCooked);

        int actualNumOfCooked = backOutputData.getNumOfCooked();

        assertEquals(expectedNumOfCooked, actualNumOfCooked, "getNumOfCooked should return the number of cooked items set in the constructor.");
    }
}
