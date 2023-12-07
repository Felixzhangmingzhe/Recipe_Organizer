package use_case.cooked;

import org.json.JSONException;

public interface CookedInputBoundary {
    void execute(CookedInputData inputData) throws JSONException;
    }

