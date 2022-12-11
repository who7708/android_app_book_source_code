package com.ansen.gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.List;

/**
 * @author ansen
 * @create time 2016-12-13
 */
public class GridAdapter extends BaseAdapter{
    private LayoutInflater inflater;
    private List<Integer> images;

    public GridAdapter(Context context,List<Integer> images){
        inflater=LayoutInflater.from(context);
        this.images=images;
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public Object getItem(int position) {
        return images.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView==null){
            viewHolder=new ViewHolder();
            convertView = inflater.inflate(R.layout.activity_grid_item, parent, false);
            viewHolder.imageview = (ImageView) convertView.findViewById(R.id.imageview);
            convertView.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder) convertView.getTag();
        }

        viewHolder.imageview.setImageResource(images.get(position));
        return convertView;
    }

    private class ViewHolder{
        private ImageView imageview;
    }
}
