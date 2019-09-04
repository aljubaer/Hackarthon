package com.example.agriapp_t.ui.land_list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.agriapp_t.R;
import com.example.agriapp_t.data.model.Land;
import com.example.agriapp_t.ui.land_dashboard.LandDashboardActivity;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import java.util.List;

public class LandListActivity extends AppCompatActivity {


    private LandViewModel landViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_land_list);

        ExtendedFloatingActionButton actionButton = findViewById(R.id.buttonAddLand);
        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LandListActivity.this,
                        AddLandActivity.class);
                startActivity(intent);
                // TODO: 6/11/19 activity for result
            }
        });

        RecyclerView recyclerView = findViewById(R.id.landListRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        final LandAdapter adapter = new LandAdapter();
        recyclerView.setAdapter(adapter);

        landViewModel = ViewModelProviders.of(this).get(LandViewModel.class);
        landViewModel.getAllLands().observe(this, new Observer<List<Land>>() {
            @Override
            public void onChanged(List<Land> lands) {
                adapter.submitList(lands);
            }
        });

        adapter.setOnItemClickListener(new LandAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Land land) {
                Intent intent = new Intent(LandListActivity.this,
                        LandDashboardActivity.class);
                startActivity(intent);
            }
        });
    }
}
