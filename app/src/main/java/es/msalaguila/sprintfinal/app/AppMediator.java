package es.msalaguila.sprintfinal.app;

import android.app.Application;

import es.msalaguila.sprintfinal.detail.DetailState;
import es.msalaguila.sprintfinal.master.MasterState;

public class AppMediator extends Application {

  private MasterState masterState = new MasterState();
  private DetailState detailState = new DetailState();

  private MasterItem masterItem;

  public void setMasterState(MasterState state) {
    this.masterState = state;
  }

  public MasterState getMasterState() {
    return masterState;
  }

  public void setDetailState(DetailState state) {
    this.detailState = state;
  }

  public DetailState getDetailState() {
    return detailState;
  }

  public MasterItem getMasterItem() {
    return masterItem;
  }

  public void setMasterItem(MasterItem item) {
    this.masterItem = item;
  }
}
