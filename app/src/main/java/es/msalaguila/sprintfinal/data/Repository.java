package es.msalaguila.sprintfinal.data;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import es.msalaguila.sprintfinal.app.MasterItem;

public class Repository implements RepositoryContract {

  public static String TAG = Repository.class.getSimpleName();

  private static Repository INSTANCE;
  private Context context;
  private int id = 0;
  private int clicksTotales = 0;
  private int clicksPerItem = 0;
  private List<MasterItem> masterItemList = new ArrayList<>();

  public static Repository getInstance(Context context) {
    if(INSTANCE == null){
      INSTANCE = new Repository(context);
    }
    return INSTANCE;
  }

  private Repository(Context context) {
    this.context = context;
  }


  @Override
  public void addNewMasterItem(OnMasterItemAddedCallback callback) {
    this.id += 1;
    MasterItem masterItem = new MasterItem(this.id, clicksPerItem);
    masterItemList.add(masterItem);
    callback.setMasterItemListAdded(masterItemList);
  }

  @Override
  public void loadMasterItemList(OnMasterItemListFetchedCallback callback) {
    callback.setMasterItemList(masterItemList);
  }
}
