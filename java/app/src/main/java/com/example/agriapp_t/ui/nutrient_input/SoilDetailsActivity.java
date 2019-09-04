package com.example.agriapp_t.ui.nutrient_input;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.agriapp_t.R;
import com.ramotion.fluidslider.FluidSlider;

import java.math.RoundingMode;
import java.text.DecimalFormat;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

public class SoilDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soil_details);

        RecyclerView recyclerView = findViewById(R.id.recyclerViewNutrientInput);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        NutrientInputAdapter adapter = new NutrientInputAdapter(SoilDetailsActivity.this);
        recyclerView.setAdapter(adapter);

    }
}
