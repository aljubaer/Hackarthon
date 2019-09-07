package com.example.agriapp_t.ui;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.agriapp_t.R;
import com.example.agriapp_t.data.database.Database;
import com.example.agriapp_t.data.repository.CropRepository;
import com.example.agriapp_t.ui.nutrient_input.NutrientInputActivity;
import com.example.agriapp_t.ui.nutrient_input.NutrientResultActivity;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.tasks.OnSuccessListener;

import java.net.URI;

public class StartUpActivity extends AppCompatActivity {

    public static CropRepository cropRepository;
    public Location loc;

    private FusedLocationProviderClient fusedLocationClient;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_up);

        cropRepository = new CropRepository(getApplication());
        Button testButton = findViewById(R.id.test_btn);


       /* fusedLocationClient.getLastLocation()
                .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        // Got last known location. In some rare situations this can be null.
                        if (location != null) {
                            // Logic to handle location object
                            loc = location;
                            System.out.println(loc.getLatitude() +"---------"+ loc.getLongitude());
                        }
                    }
                });
*/
    }

    public void onTest (View view) {
        cropRepository.test();
    }


    public void onTest2 (View view) {
        Intent intent = new Intent(StartUpActivity.this, CropInputActivity.class);
        startActivity(intent);
    }

    public void onTest3 (View view) {
        // &waypoints=18.520561,73.872435|18.519254,73.876614|18.52152,73.877327|18.52019,73.879935
        //&destination=18.518496,73.879259&travelmode=driving
        //String url = "https://www.google.com/maps/dir/?api=1&origin=22.8931175,89.3712238?q=fertilizer";
        String url = "https://www.google.com/maps/search/nearest+fertilizer/@22.8931791,89.4938002,10z";

        //String url = "https://www.google.com/maps/search/nearest+fertilizer/@"+loc.getLatitude()+","+loc.getLongitude()+",10z";

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
