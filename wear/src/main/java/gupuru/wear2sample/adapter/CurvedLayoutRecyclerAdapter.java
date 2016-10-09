package gupuru.wear2sample.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.wearable.view.WearableRecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import gupuru.wear2sample.R;

public class CurvedLayoutRecyclerAdapter extends WearableRecyclerView.Adapter<CurvedLayoutRecyclerAdapter.ViewHolder> {

    private ArrayList<String> mData;
    private Context mContext;

    public CurvedLayoutRecyclerAdapter(Context context, ArrayList<String> data) {
        mContext = context;
        mData = data;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mTextView;
        private LinearLayout linearLayout;

        ViewHolder(View view) {
            super(view);
            mTextView = (TextView) view.findViewById(R.id.text_item);
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
        if (mData != null && !mData.isEmpty() ) {
            holder.mTextView.setText(mData.get(position));
            holder.linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(mContext, mData.get(position), Toast.LENGTH_LONG).show();
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        if (mData != null && !mData.isEmpty()) {
            return mData.size();
        }
        return 0;
    }

}