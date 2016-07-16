package com.chen.recyclerviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenti on 2016/7/16.
 */
public class RecyclerViewAdapter extends android.support.v7.widget.RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<String> list = new ArrayList<String>();

    private static final int TYPE_ITEM = 0;
    private static final int TYPE_FOOT = 1;
    private static final int TYPE_HEAD = 2;

    public RecyclerViewAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_ITEM) {
            View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
            RecyclerView.ViewHolder vh = new ItemViewHolder(view);
            return vh;
        } else if (viewType == TYPE_HEAD) {
            View view = LayoutInflater.from(context).inflate(R.layout.head, parent, false);
            RecyclerView.ViewHolder vh = new HeadViewHolder(view);
            return vh;
        } else if (viewType == TYPE_FOOT) {
            View view = LayoutInflater.from(context).inflate(R.layout.foot, parent, false);
            RecyclerView.ViewHolder vh = new FootViewHolder(view);
            return vh;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder) {
            ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
            itemViewHolder.textView.setText(list.get(position-1));
        } else if (holder instanceof HeadViewHolder) {
            HeadViewHolder headViewHolder = (HeadViewHolder) holder;
            headViewHolder.textView.setText("RecyclerView Head");
            headViewHolder.textView.setTextSize(20);
        } else if (holder instanceof FootViewHolder) {
            FootViewHolder footViewHolder = (FootViewHolder) holder;
            footViewHolder.textView.setText("RecyclerView Foot");
            footViewHolder.textView.setTextSize(20);
        }
    }

    @Override
    public int getItemCount() {
        return list.size() + 2;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_HEAD;
        } else if (position + 1 == getItemCount()) {
            return TYPE_FOOT;
        } else {
            return TYPE_ITEM;
        }
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        private View root;
        private TextView textView;

        public ItemViewHolder(View itemView) {
            super(itemView);
            root = itemView;
            textView = (TextView) root.findViewById(R.id.textView);
        }
    }

    public class HeadViewHolder extends RecyclerView.ViewHolder {

        private View root;
        private TextView textView;

        public HeadViewHolder(View itemView) {
            super(itemView);
            root = itemView;
            textView = (TextView) root.findViewById(R.id.textView);
        }
    }

    public class FootViewHolder extends RecyclerView.ViewHolder {

        private View root;
        private TextView textView;

        public FootViewHolder(View itemView) {
            super(itemView);
            root = itemView;
            textView = (TextView) root.findViewById(R.id.textView);
        }
    }
}
