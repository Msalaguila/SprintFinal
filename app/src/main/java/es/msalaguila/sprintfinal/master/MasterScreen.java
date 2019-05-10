package es.msalaguila.sprintfinal.master;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

import es.msalaguila.sprintfinal.app.AppMediator;
import es.msalaguila.sprintfinal.data.Repository;
import es.msalaguila.sprintfinal.data.RepositoryContract;

public class MasterScreen {

  public static void configure(MasterContract.View view) {

    WeakReference<FragmentActivity> context =
            new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    MasterState state = mediator.getMasterState();

    RepositoryContract repository = Repository.getInstance(context.get());
    MasterContract.Router router = new MasterRouter(mediator);
    MasterContract.Presenter presenter = new MasterPresenter(state);
    MasterContract.Model model = new MasterModel(repository);
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
