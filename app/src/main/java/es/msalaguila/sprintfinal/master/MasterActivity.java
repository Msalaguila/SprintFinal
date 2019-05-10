package es.msalaguila.sprintfinal.master;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import es.msalaguila.sprintfinal.R;
import es.msalaguila.sprintfinal.app.MasterItem;

public class MasterActivity
        extends AppCompatActivity implements MasterContract.View {

  public static String TAG = MasterActivity.class.getSimpleName();

  private MasterContract.Presenter presenter;
  private ListView listView;
  private Button button;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_master);

    listView = findViewById(R.id.master_list);

    button = findViewById(R.id.masterButton);

    // do the setup
    MasterScreen.configure(this);
  }

  @Override
  protected void onResume() {
    super.onResume();

    // do some work
    presenter.fetchMasterItemsData();
  }

  @Override
  public void injectPresenter(MasterContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void displayData(MasterViewModel viewModel) {
    //Log.e(TAG, "displayData()");

    // deal with the data

    listView.setAdapter(new MasterAdapter(
                    this, viewModel.masterItemList, new View.OnClickListener() {

              @Override
              public void onClick(View view) {
                MasterItem item = (MasterItem) view.getTag();
                presenter.selectMasterItemData(item);
              }
            })
    );
  }

  public void onButtonPressed(View view) {
    presenter.addNewMasterItem();
  }
}
