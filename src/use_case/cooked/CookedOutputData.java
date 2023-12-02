package use_case.cooked;

public class CookedOutputData {
    private boolean setCookedSuccess;
    public CookedOutputData(boolean setCookedSuccess) {
        this.setCookedSuccess = setCookedSuccess;
    }
    public boolean getSetCookedSuccess() {
        return setCookedSuccess;
    }
}
