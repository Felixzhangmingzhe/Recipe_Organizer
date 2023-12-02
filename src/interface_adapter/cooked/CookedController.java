package interface_adapter.cooked;

import use_case.cooked.CookedInputBoundary;
import use_case.cooked.CookedInputData;

public class CookedController {
    private CookedInputBoundary cookedInteractor;
    public CookedController(CookedInputBoundary cookedInteractor) {
        this.cookedInteractor = cookedInteractor;
    }
    public void execute(String recipeTitle) {
        CookedInputData inputData = new CookedInputData(recipeTitle);
        cookedInteractor.execute(inputData);
    }
}
