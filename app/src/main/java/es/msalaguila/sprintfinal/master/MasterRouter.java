package es.msalaguila.sprintfinal.master;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import es.msalaguila.sprintfinal.app.AppMediator;
import es.msalaguila.sprintfinal.app.MasterItem;
import es.msalaguila.sprintfinal.detail.DetailActivity;

public class MasterRouter implements MasterContract.Router {

  public static String TAG = MasterRouter.class.getSimpleName();

  private AppMediator mediator;

  public MasterRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void navigateToNextScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, DetailActivity.class);
    context.startActivity(intent);
  }

  @Override
  public void passDataToNextScreen(MasterState state) {
    mediator.setMasterState(state);
  }

  @Override
  public MasterState getDataFromPreviousScreen() {
    MasterState state = mediator.getMasterState();
    return state;
  }

  @Override
  public void passMasterItemToNextScreen(MasterItem item) {
    mediator.setMasterItem(item);
  }
}
