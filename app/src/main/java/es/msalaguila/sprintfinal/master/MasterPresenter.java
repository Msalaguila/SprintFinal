package es.msalaguila.sprintfinal.master;

import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.List;

import es.msalaguila.sprintfinal.app.MasterItem;
import es.msalaguila.sprintfinal.data.RepositoryContract;

public class MasterPresenter implements MasterContract.Presenter {

  public static String TAG = MasterPresenter.class.getSimpleName();

  private WeakReference<MasterContract.View> view;
  private MasterViewModel viewModel;
  private MasterContract.Model model;
  private MasterContract.Router router;

  public MasterPresenter(MasterState state) {
    viewModel = state;
  }

  @Override
  public void injectView(WeakReference<MasterContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(MasterContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(MasterContract.Router router) {
    this.router = router;
  }

  @Override
  public void fetchData() {
    // Log.e(TAG, "fetchData()");

    // set passed state
    MasterState state = router.getDataFromPreviousScreen();
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
  public void fetchMasterItemsData() {
    model.loadMasterItems(new RepositoryContract.OnMasterItemListFetchedCallback() {
      @Override
      public void setMasterItemList(List<MasterItem> itemList) {
        viewModel.masterItemList = itemList;
        view.get().displayData(viewModel);
      }
    });
  }

  @Override
  public void addNewMasterItem() {
    model.addNewMasterItem(new RepositoryContract.OnMasterItemAddedCallback() {
      @Override
      public void setMasterItemListAdded(List<MasterItem> itemList) {
        viewModel.masterItemList = itemList;
        view.get().displayData(viewModel);
      }
    });
  }


}
