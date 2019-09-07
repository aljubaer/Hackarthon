package com.example.agriapp_t.ui.nutrient_input;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.agriapp_t.R;

public class NutrientInputActivity extends AppCompatActivity {

    TextView NitrogenAmount;
    double nitrogenAmount;
    String nitrogenAmountText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrient_input);
        NitrogenAmount = findViewById(R.id.nitrogen_amount);
    }

    public void onRadioButtonClickedNitrogen(View view){
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_low_nitrogen:
                if (checked)
                    nitrogenAmountText = "low";
                    break;
            case R.id.radio_medium_nitrogen:
                if (checked)
                    nitrogenAmountText = "medium";
                    break;
            case R.id.radio_high_nitrogen:
                if (checked)
                    nitrogenAmountText = "high";
                break;
        }
        NitrogenAmount.setText(nitrogenAmountText);

    }
}
