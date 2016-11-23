package gupuru.wear2sample.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.wearable.view.WearableRecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import gupuru.wear2sample.R;
import gupuru.wear2sample.model.RecyclerViewItemModel;

public class CurvedLayoutRecyclerAdapter extends WearableRecyclerView.Adapter<CurvedLayoutRecyclerAdapter.ViewHolder> {

    private ArrayList<RecyclerViewItemModel> recyclerViewItemModels;
    private Context mContext;

    public CurvedLayoutRecyclerAdapter(Context context, ArrayList<RecyclerViewItemModel> recyclerViewItemModels) {
        this.mContext = context;
        this.recyclerViewItemModels = recyclerViewItemModels;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mTextView;
        private ImageView imageView;
        private LinearLayout linearLayout;

        ViewHolder(View view) {
            super(view);
            mTextView = (TextView) view.findViewById(R.id.text_item);
            imageView = (ImageView) view.findViewById(R.id.image_item);
            linearLayout = (LinearLayout) view.findViewById(R.id.layout);
        }
    }

    @Override
    public CurvedLayoutRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_curved_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(CurvedLayoutRecyclerAdapter.ViewHolder holder, final int position) {
        if (recyclerViewItemModels != null && !recyclerViewItemModels.isEmpty() ) {
            holder.mTextView.setText(recyclerViewItemModels.get(position).getTitle());
            holder.imageView.setImageResource(recyclerViewItemModels.get(position).getImage());
            holder.linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(mContext, recyclerViewItemModels.get(position).getTitle(), Toast.LENGTH_LONG).show();
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        if (recyclerViewItemModels != null && !recyclerViewItemModels.isEmpty()) {
            return recyclerViewItemModels.size();
        }
        return 0;
    }

}