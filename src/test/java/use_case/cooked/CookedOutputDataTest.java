package use_case.cooked;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CookedOutputDataTest {

    @Test
    void testCookedOutputData() {
        boolean setCookedSuccess = true;

        CookedOutputData outputData = new CookedOutputData(setCookedSuccess);

        assertEquals(setCookedSuccess, outputData.getSetCookedSuccess());
    }
}
