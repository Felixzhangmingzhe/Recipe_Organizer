package interface_adapter.Back;

import use_case.Back.BackOutputData;

public class BackState {
    private int numOfCooked;
    public BackState(BackState copy) {
        this.numOfCooked = copy.numOfCooked;
    }
    public BackState() {
    }

    public void setNumOfCooked(int numOfCooked) {
        this.numOfCooked = numOfCooked;
    }
    public int getNumOfCooked() {
        return numOfCooked;
    }
}
