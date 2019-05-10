package es.msalaguila.sprintfinal.data;

import java.util.List;

import es.msalaguila.sprintfinal.app.MasterItem;

public interface RepositoryContract {
  interface OnMasterItemListFetchedCallback {
    void setMasterItemList(List<MasterItem> itemList);
  }

  interface OnMasterItemAddedCallback {
    void setMasterItemListAdded(List<MasterItem> itemList);
  }

  void addNewMasterItem(RepositoryContract.OnMasterItemAddedCallback callback);

  void loadMasterItemList(RepositoryContract.OnMasterItemListFetchedCallback callback);
}
