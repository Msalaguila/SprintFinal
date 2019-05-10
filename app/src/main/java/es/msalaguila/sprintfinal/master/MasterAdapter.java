package es.msalaguila.sprintfinal.master;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import es.msalaguila.sprintfinal.R;
import es.msalaguila.sprintfinal.app.MasterItem;

public class MasterAdapter extends ArrayAdapter<MasterItem> {


  private final List<MasterItem> itemList;
  private final View.OnClickListener clickListener;


  public MasterAdapter(
          Context context, List<MasterItem> items, View.OnClickListener listener) {

    super(context, 0, items);

    itemList = items;
    clickListener = listener;
  }

  @Override
  public int getCount() {
    return itemList.size();
  }

  @Override
  public MasterItem getItem(int position) {
    return itemList.get(position);
  }

  @Override
  public long getItemId(int position) {
    return itemList.get(position).id;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    View itemView = convertView;

    if (itemView == null) {
      itemView = LayoutInflater
              .from(parent.getContext())
              .inflate(R.layout.master_recycler_cell, parent, false);
    }

    itemView.setTag(itemList.get(position));
    itemView.setOnClickListener(clickListener);

    final TextView contentView = itemView.findViewById(R.id.recylerCellTextView);
    contentView.setText(String.valueOf(itemList.get(position).clicks));

    return itemView;
  }

}
