package use_case.add_to_favorites;

public class AddToFavoritesInteractor implements AddToFavoritesInputBoundary {
    private final AddToFavoritesDataAccessInterface userDataAccess;
    private final AddToFavoritesOutputBoundary presenter;

    public AddToFavoritesInteractor(AddToFavoritesDataAccessInterface userDataAccess, AddToFavoritesOutputBoundary presenter) {
        this.userDataAccess = userDataAccess;
        this.presenter = presenter;
    }

//    @Override
//    public void execute(AddToFavoritesInputData inputData) {
//        if (inputData.getId() < 0) {
//            presenter.prepareFailView("Invalid ID");
//        } else {
//            userDataAccess.addToFavorites(inputData.getId());
//            presenter.prepareSuccessView();
//        }
//    }
}
