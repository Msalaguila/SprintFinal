package es.msalaguila.sprintfinal.detail;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.msalaguila.sprintfinal.app.MasterItem;
import es.msalaguila.sprintfinal.data.RepositoryContract;

public class DetailPresenter implements DetailContract.Presenter {

  public static String TAG = DetailPresenter.class.getSimpleName();

  private WeakReference<DetailContract.View> view;
  private DetailViewModel viewModel;
  private DetailContract.Model model;
  private DetailContract.Router router;

  public DetailPresenter(DetailState state) {
    viewModel = state;
  }

  @Override
  public void injectView(WeakReference<DetailContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(DetailContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(DetailContract.Router router) {
    this.router = router;
  }

  @Override
  public void fetchData() {
    // Log.e(TAG, "fetchData()");

    // set passed state
    DetailState state = router.getDataFromPreviousScreen();
    if (state != null) {
      viewModel.data = state.data;
    }

    if (viewModel.data == null) {
      // call the model
      String data = model.fetchData();

      // set initial state
      viewModel.data = data;
    }

    // update the view
    view.get().displayData(viewModel);

  }

  @Override
  public void fetchMasterItemData() {
    MasterItem item = router.getMasterItemFromPreviousScreen();
    if (item != null) {
      viewModel.masterItem = item;
      view.get().displayData(viewModel);
    }
  }

  @Override
  public void updateItemAndCLicks() {
    int item_id = viewModel.masterItem.id;
    model.updateItemAndClicks(item_id, new RepositoryContract.OnMasterItemUpdatedCallback() {
      @Override
      public void setMasterItemUpdated(MasterItem item, int totalClicks) {
        viewModel.masterItem = item;
        viewModel.totalClicks = totalClicks;

        view.get().displayData(viewModel);
      }
    });
  }


}
