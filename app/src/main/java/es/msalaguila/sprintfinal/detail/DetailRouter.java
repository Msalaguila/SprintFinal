package es.msalaguila.sprintfinal.detail;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import es.msalaguila.sprintfinal.app.AppMediator;
import es.msalaguila.sprintfinal.app.MasterItem;

public class DetailRouter implements DetailContract.Router {

  public static String TAG = DetailRouter.class.getSimpleName();

  private AppMediator mediator;

  public DetailRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void navigateToNextScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, DetailActivity.class);
    context.startActivity(intent);
  }

  @Override
  public void passDataToNextScreen(DetailState state) {
    mediator.setDetailState(state);
  }

  @Override
  public DetailState getDataFromPreviousScreen() {
    DetailState state = mediator.getDetailState();
    return state;
  }

  @Override
  public MasterItem getMasterItemFromPreviousScreen() {
    MasterItem item = mediator.getMasterItem();
    return item;
  }
}
