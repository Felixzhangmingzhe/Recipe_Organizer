package app;

import data_access.FileRecipeDataAccessObject;
import org.json.JSONException;

import java.io.IOException;
import java.util.List;

// An abstract class to prepare different presetted data for different use cases
public interface DataPresetter {
    public void presetData(FileRecipeDataAccessObject DAO) throws JSONException;
    public void presetDataOutside(FileRecipeDataAccessObject DAO, int numberOfObject) throws IOException;
}
