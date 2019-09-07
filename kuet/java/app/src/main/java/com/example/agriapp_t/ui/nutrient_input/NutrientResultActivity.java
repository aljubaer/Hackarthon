package com.example.agriapp_t.ui.nutrient_input;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

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

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            Required_dose_urea.setText(String.valueOf( bundle.getDouble("rn") * .46) + " kg/ha");
            Required_dose_tsp.setText(String.valueOf( bundle.getDouble("rp") *0.2)  + " kg/ha");
            Required_dose_mop.setText(String.valueOf( bundle.getDouble("rk") * 0.5)  + " kg/ha");
            Required_dose_gupsum.setText(String.valueOf( bundle.getDouble("rs") * .18)  + " kg/ha");

            Cost_urea.setText(String.valueOf( bundle.getDouble("rn") * 0.46 *20.0)  + " tk");
            Cost_tsp.setText(String.valueOf( bundle.getDouble("rp") *0.2 * 22.0 ) + " tk");
            Cost_mop.setText(String.valueOf( bundle.getDouble("rk") * .5 * 17.0) + " tk");
            Cost_gypsum.setText(String.valueOf( bundle.getDouble("rs") * .18 * 12.0) + " tk");

        }


    }
}
