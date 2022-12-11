package com.ansen.tablayout.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ansen.tablayout.R;

/**
 * Created by  ansen
 * Create Time 2017-04-07
 */
public class FragmentTest extends Fragment{
    private RecyclerView recyclerView;
    private String[] data=new String[20];

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView=LayoutInflater.from(getActivity()).inflate(R.layout.fragment_test, null);
        recyclerView= (RecyclerView) rootView.findViewById(R.id.recyclerView);

        initData();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new RecyclerViewAdapter());
        return rootView;
    }

    public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>{
        @Override
        public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder holder = new MyViewHolder(LayoutInflater.from(getActivity()).inflate(android.R.layout.simple_list_item_1, parent,false));
            return holder;
        }

        @Override
        public void onBindViewHolder(RecyclerViewAdapter.MyViewHolder holder, int position) {
            holder.text1.setText(data[position]);
        }

        @Override
        public int getItemCount() {
            return data.length;
        }

        class MyViewHolder extends RecyclerView.ViewHolder{
            TextView text1;
            public MyViewHolder(View view){
                super(view);
                text1 = (TextView) view.findViewById(android.R.id.text1);
            }
        }
    }

    private void initData(){
        for(int i=0;i<data.length;i++){
            data[i]="test"+i;
        }
    }
}
