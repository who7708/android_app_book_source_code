package com.ansen.myapplication.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.ansen.myapplication.adapter.ItemAdapter;
import com.ansen.myapplication.data.Datasource;
import com.ansen.myapplication.databinding.ActivityRecyclerViewBinding;
import com.ansen.myapplication.model.Affirmation;

import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    private ActivityRecyclerViewBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = ActivityRecyclerViewBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        Datasource datasource = new Datasource();
        List<Affirmation> affirmations = datasource.loadAffirmations();
        // mBinding.tvShow.setText(String.valueOf(affirmations.size()));

        ItemAdapter itemAdapter = new ItemAdapter(this, affirmations);
        RecyclerView recyclerView = mBinding.recyclerView;
        recyclerView.setAdapter(itemAdapter);
        // Use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // recyclerView.getLayoutManager()
    }
}