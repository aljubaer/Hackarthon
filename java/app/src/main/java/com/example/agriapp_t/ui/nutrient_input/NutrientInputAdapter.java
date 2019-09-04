package com.example.agriapp_t.ui.nutrient_input;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.agriapp_t.R;

import java.util.List;

public class NutrientInputAdapter extends RecyclerView.Adapter<NutrientInputAdapter.ViewHolder> {

    private Context context;
    private NutrientInputModel[] nutrientInputModels = new NutrientInputModel[3];
    private double[] nutrientInputValues = new double[3];

    public NutrientInputAdapter(Context context) {
        this.context = context;
        nutrientInputModels[0] = new NutrientInputModel("Enter % nitrogen", 0.0, "Very Low");
        nutrientInputModels[1] = new NutrientInputModel("Enter % phosphorus", 0.0, "Very Low");
        nutrientInputModels[2] = new NutrientInputModel("Enter % potassium", 0.0, "Very Low");

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.card_nutrient_status, parent, false);
        NutrientInputAdapter.ViewHolder viewHolder = new NutrientInputAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NutrientInputModel currentInput = nutrientInputModels[position];
        holder.textViewTitle.setText(currentInput.getTitle());
        holder.editTextNutrientValue.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    nutrientInputValues[position] = Double.valueOf(s.toString());
                } catch (Exception e) {  }
                Toast.makeText(context, String.valueOf(nutrientInputValues[position]), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return nutrientInputModels.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle;
        EditText editTextNutrientValue;
        RadioGroup radioGroupStatus;
        RadioButton radioButtonsStatusVeryLow;
        RadioButton radioButtonsStatusLow;
        RadioButton radioButtonsStatusMedium;
        RadioButton radioButtonsStatusOptimum;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.textViewNutrientInputTitle);
            editTextNutrientValue = itemView.findViewById(R.id.editTextNutrientInputValue);
            radioGroupStatus = itemView.findViewById(R.id.radioGroupNutrient);
            radioButtonsStatusVeryLow = itemView.findViewById(R.id.radioNVL);
            radioButtonsStatusLow = itemView.findViewById(R.id.radioNL);
            radioButtonsStatusMedium = itemView.findViewById(R.id.radioNM);
            radioButtonsStatusOptimum = itemView.findViewById(R.id.radioNO);
        }
    }
}
