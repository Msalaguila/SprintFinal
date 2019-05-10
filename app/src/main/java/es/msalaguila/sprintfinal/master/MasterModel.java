package es.msalaguila.sprintfinal.master;

import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentActivity;

import es.msalaguila.sprintfinal.app.MasterItem;
import es.msalaguila.sprintfinal.data.RepositoryContract;

public class MasterModel implements MasterContract.Model {

  public static String TAG = MasterModel.class.getSimpleName();

  private RepositoryContract repository;

  public MasterModel(RepositoryContract repository) {
    this.repository = repository;
  }

  @Override
  public String fetchData() {
    // Log.e(TAG, "fetchData()");
    return "Hello";
  }

  @Override
  public void loadMasterItems(RepositoryContract.OnMasterItemListFetchedCallback callback) {
    repository.loadMasterItemList(callback);
  }


  @Override
  public void addNewMasterItem(RepositoryContract.OnMasterItemAddedCallback callback) {
    repository.addNewMasterItem(callback);
  }


}
