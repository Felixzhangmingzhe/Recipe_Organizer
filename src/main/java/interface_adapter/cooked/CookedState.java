package interface_adapter.cooked;

public class CookedState {
    private boolean setCookedSuccess;
    public CookedState(CookedState copy) {
        this.setCookedSuccess = copy.setCookedSuccess;
    }
    public CookedState() {
    }
    public void setSetCookedSuccess(boolean setCookedSuccess) {
        this.setCookedSuccess = setCookedSuccess;
    }
    public boolean getSetCookedSuccess() {
        return setCookedSuccess;
    }
}
