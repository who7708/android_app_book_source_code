package com.ansen.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ansen.myapplication.R;
import com.ansen.myapplication.model.Affirmation;

import java.util.List;

/**
 * @author Chris
 * @version 1.0
 * @since 2022-12-15
 */
public class ItemAdapter extends RecyclerView.Adapter {
    /**
     * 上下文
     */
    private final Context mContext;

    /**
     * 数据集
     */
    private final List<Affirmation> dataset;

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
        // String title = mContext.getResources().getString(item.getStringResourceId());
        TextView textView = ((ItemViewHolder) holder).getTextView();
        textView.setText(item.getStringResourceId());

        ImageView imageView = ((ItemViewHolder) holder).getImageView();
        imageView.setImageResource(item.getImageResourceId());
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;

        private ImageView imageView;

        public TextView getTextView() {
            return textView;
        }

        public ImageView getImageView() {
            return imageView;
        }

        public void setTextView(TextView textView) {
            this.textView = textView;
        }

        public void setImageView(ImageView imageView) {
            this.imageView = imageView;
        }

        public ItemViewHolder(@NonNull View view) {
            super(view);
            textView = view.findViewById(R.id.item_title);
            imageView = view.findViewById(R.id.item_image);
        }
    }
}
