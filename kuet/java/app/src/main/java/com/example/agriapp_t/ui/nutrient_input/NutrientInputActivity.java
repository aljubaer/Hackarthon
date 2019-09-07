package com.example.agriapp_t.ui.nutrient_input;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.agriapp_t.R;
import com.example.agriapp_t.ui.StartUpActivity;
import com.example.agriapp_t.ui.custom_listener.OnNutrientDataFetched;

public class NutrientInputActivity extends AppCompatActivity implements OnNutrientDataFetched {

    TextView NitrogenAmount;
    double nitrogenAmount;
    String nitrogenStatus;
    int cropClass = 1;
    String textureClass;
    double requiredN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrient_input);
        NitrogenAmount = findViewById(R.id.nitrogen_amount);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            cropClass = 1;
            textureClass = bundle.getString("texture_class");
        }
    }

    public void onRadioButtonClickedNitrogen(View view){
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_low_nitrogen:
                if (checked)
                    nitrogenStatus = "Low";
                    break;
            case R.id.radio_medium_nitrogen:
                if (checked)
                    nitrogenStatus = "Medium";
                    break;
            case R.id.radio_high_nitrogen:
                if (checked)
                    nitrogenStatus = "High";
                break;
        }
        NitrogenAmount.setText(nitrogenStatus);

        StartUpActivity.cropRepository.getNutrientRecommendation(1, nitrogenStatus, "N", this);

    }

    @Override
    public void onAfterDataFetched(double uf, double ci, String nutrient) {
        System.out.println("+++++++" + ci + nutrient);
        if (nutrient.equals("N")){
            if (ci < 0.000001) requiredN = 0.0;
            requiredN = uf - (ci / 2.0);
            System.out.println(requiredN);
        }

    }

//    public void onRadioButtonClickedP(View view){
//        boolean checked = ((RadioButton) view).isChecked();
//
//        // Check which radio button was clicked
//        switch(view.getId()) {
//            case R.id.radio_low_nitrogenP:
//                if (checked)
//                    nitrogenStatus = "low";
//                break;
//            case R.id.radio_medium_nitrogenP:
//                if (checked)
//                    nitrogenStatus = "medium";
//                break;
//            case R.id.radio_high_nitrogenP:
//                if (checked)
//                    nitrogenStatus = "high";
//                break;
//        }
//        NitrogenAmount.setText(nitrogenStatus);
//
//    }



}
