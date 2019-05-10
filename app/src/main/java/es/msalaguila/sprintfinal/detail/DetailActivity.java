package es.msalaguila.sprintfinal.detail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import es.msalaguila.sprintfinal.R;

public class DetailActivity
        extends AppCompatActivity implements DetailContract.View {

  public static String TAG = DetailActivity.class.getSimpleName();

  private DetailContract.Presenter presenter;
  private TextView counterClicksPerItemTextView;
  private TextView totalClicksTextView;
  private Button updateItemButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_detail);

    counterClicksPerItemTextView = findViewById(R.id.counterClicksPerItemTextView);
    totalClicksTextView = findViewById(R.id.totalClicksTextView);
    updateItemButton = findViewById(R.id.updateItemButton);

    // do the setup
    DetailScreen.configure(this);
  }

  @Override
  protected void onResume() {
    super.onResume();

    // do some work
    presenter.fetchMasterItemData();
  }

  @Override
  public void injectPresenter(DetailContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void displayData(DetailViewModel viewModel) {
    //Log.e(TAG, "displayData()");

    // deal with the data

    counterClicksPerItemTextView.setText(String.valueOf(viewModel.masterItem.clicks));
  }

  public void onUpdateItemButtonClicked(View view) {

  }

}
