package com.ansen.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ansen.myapplication.model.Affirmation;

import java.util.List;

/**
 * @author Chris
 * @version 1.0
 * @since 2022-12-15
 */
public class ItemAdapter extends RecyclerView.Adapter {
    private Context mContext;

    private List<Affirmation> dataset;

    public ItemAdapter(Context mContext, List<Affirmation> dataset) {
        this.mContext = mContext;
        this.dataset = dataset;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ItemViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Affirmation item = dataset.get(position);
        String title = mContext.getResources().getString(item.getStringResourceId());
        TextView itemView = (TextView) holder.itemView;
        itemView.setText(title);
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        public ItemViewHolder(@NonNull View view) {
            super(view.findViewById(R.id.item_title));
        }
    }
}
