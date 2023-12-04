package app;

import data_access.FileRecipeDataAccessObject;
import entity.Recipe;

import java.io.IOException;
import java.util.List;

// a abstract class that is used to prepare different presetted data for different use cases
public interface DataPresetter {
    public void presetData(FileRecipeDataAccessObject dao);
    public void presetDataOutside(FileRecipeDataAccessObject dao, int numberOfObject) throws IOException;

}
