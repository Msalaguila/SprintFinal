package es.msalaguila.sprintfinal.detail;

import java.lang.ref.WeakReference;

import es.msalaguila.sprintfinal.app.MasterItem;

interface DetailContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(DetailViewModel viewModel);
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void fetchData();

    void fetchMasterItemData();
  }

  interface Model {
    String fetchData();
  }

  interface Router {
    void navigateToNextScreen();

    void passDataToNextScreen(DetailState state);

    DetailState getDataFromPreviousScreen();

    MasterItem getMasterItemFromPreviousScreen();
  }
}
