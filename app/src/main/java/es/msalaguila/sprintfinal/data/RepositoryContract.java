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

  interface OnMasterItemUpdatedCallback {
    void setMasterItemUpdated(MasterItem item, int totalClicks);
  }

  void addNewMasterItem(RepositoryContract.OnMasterItemAddedCallback callback);

  void loadMasterItemList(RepositoryContract.OnMasterItemListFetchedCallback callback);

  void updateMasterItem(int id, RepositoryContract.OnMasterItemUpdatedCallback callback);
}
