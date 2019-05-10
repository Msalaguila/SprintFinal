package es.msalaguila.sprintfinal.master;

import java.lang.ref.WeakReference;
import java.util.List;

import es.msalaguila.sprintfinal.app.MasterItem;
import es.msalaguila.sprintfinal.data.RepositoryContract;

interface MasterContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(MasterViewModel viewModel);
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void fetchData();

    void fetchMasterItemsData();

    void addNewMasterItem();
  }

  interface Model {
    String fetchData();

    void loadMasterItems(RepositoryContract.OnMasterItemListFetchedCallback callback);

    void addNewMasterItem(RepositoryContract.OnMasterItemAddedCallback callback);
  }

  interface Router {
    void navigateToNextScreen();

    void passDataToNextScreen(MasterState state);

    MasterState getDataFromPreviousScreen();
  }
}
