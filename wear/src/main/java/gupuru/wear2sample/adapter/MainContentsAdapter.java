package gupuru.wear2sample.adapter;

import android.content.Context;
import android.support.wearable.view.WearableListView;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import gupuru.wear2sample.R;
import gupuru.wear2sample.view.MainContentsItemView;

/**
 * Main Adapter
 */
public class MainContentsAdapter extends WearableListView.Adapter {

    private final Context context;
    private final List<String> items;

    public MainContentsAdapter(Context context, List<String> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public WearableListView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new WearableListView.ViewHolder(new MainContentsItemView(context));
    }

    @Override
    public void onBindViewHolder(WearableListView.ViewHolder holder, int position) {
        MainContentsItemView mainContentsItemView = (MainContentsItemView) holder.itemView;
        TextView textView = (TextView) mainContentsItemView.findViewById(R.id.text);
        textView.setText(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

}
