package com.example.agriapp_t.ui.land_dashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.agriapp_t.R;
import com.example.agriapp_t.ui.crop_details.CurrentCropActivity;
import com.example.agriapp_t.ui.nutrient_input.SoilDetailsActivity;
import com.google.android.material.card.MaterialCardView;

public class LandDashboardActivity extends AppCompatActivity {

    CardView cardCurrentCrop, cardSoilDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_land_dashboard);

        cardCurrentCrop = (CardView)findViewById(R.id.cardCurrentCrop);
        cardCurrentCrop.setClickable(true);
        cardCurrentCrop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LandDashboardActivity.this, CurrentCropActivity.class);
                startActivity(intent);
            }
        });

        cardSoilDetails = (CardView)findViewById(R.id.cardSoilDetails);
        cardSoilDetails.setClickable(true);
        cardSoilDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LandDashboardActivity.this, SoilDetailsActivity.class);
                startActivity(intent);
            }
        });
    }

    public void onClickCardCurrentCrop(View view) {

    }
}
