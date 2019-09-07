package com.example.agriapp_t.ui.nutrient_input;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.agriapp_t.R;

public class NutrientResultActivity extends AppCompatActivity {

    TextView Cost_urea,Cost_tsp,Cost_mop,Cost_gypsum, Required_dose_urea,Required_dose_tsp,Required_dose_mop,Required_dose_gupsum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrient_result);

        Cost_urea = findViewById(R.id.cost_urea);
        Cost_tsp = findViewById(R.id.cost_tsp);
        Cost_mop = findViewById(R.id.cost_mop);
        Cost_gypsum = findViewById(R.id.cost_gypsum);

        Required_dose_urea = findViewById(R.id.required_dose_urea);
        Required_dose_tsp = findViewById(R.id.required_dose_tsp);
        Required_dose_mop = findViewById(R.id.required_dose_mop);
        Required_dose_gupsum = findViewById(R.id.required_dose_gypsum);


    }

    public void onShow(View view){
        String url = "https://www.google.com/maps/search/nearest+fertilizer/@22.8994699,89.5016482,10z";

        Uri path = Uri.parse(url);

        Intent intent = new Intent(Intent.ACTION_VIEW, path);
        intent.setPackage("com.google.android.apps.maps");
        //startActivity(intent);
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException ex) {
            try {
                Intent unrestrictedIntent = new Intent(Intent.ACTION_VIEW, path);
                startActivity(unrestrictedIntent);
            } catch (ActivityNotFoundException innerEx) {
                Toast.makeText(this, "Please install a maps application", Toast.LENGTH_LONG).show();
            }
        }
    }

    public void onDirection(View view){

        //"http://maps.google.com/maps?saddr=20.344,34.34&daddr=22.9586882,88.4502594"
        //String url = "https://www.google.com/maps/dir/?api=1&origin=22.8931175,89.3712238?q=fertilizer";
        String url = "http://maps.google.com/maps?saddr=20.344,34.34&daddr=22.9586882,88.4502594";

        Uri path = Uri.parse(url);

        Intent intent = new Intent(Intent.ACTION_VIEW, path);
        intent.setPackage("com.google.android.apps.maps");
        //startActivity(intent);
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException ex) {
            try {
                Intent unrestrictedIntent = new Intent(Intent.ACTION_VIEW, path);
                startActivity(unrestrictedIntent);
            } catch (ActivityNotFoundException innerEx) {
                Toast.makeText(this, "Please install a maps application", Toast.LENGTH_LONG).show();
            }
        }
    }
}
