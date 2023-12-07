package use_case.add_to_favorites;

import org.json.JSONException;

public interface AddToFavoritesInputBoundary {
    void execute(AddToFavoritesInputData inputData) throws JSONException;
}
