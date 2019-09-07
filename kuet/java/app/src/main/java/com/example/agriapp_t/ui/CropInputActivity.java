package com.example.agriapp_t.ui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.agriapp_t.R;
import com.example.agriapp_t.ui.custom_components.CustomListDialog;
import com.example.agriapp_t.ui.custom_listener.OnDataFetchListener;
import com.example.agriapp_t.ui.custom_listener.OnListItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class CropInputActivity extends AppCompatActivity implements OnListItemClickListener, OnDataFetchListener {

    public Button btnInputCrop, btnInputTexture;
    private ArrayList<String> cropList = new ArrayList<>();
    private ArrayList<String> textureList = new ArrayList<>();
    private AlertDialog mAlertDialog = null;
    private Boolean isDataFetched = false;
    private String crop, texture;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop_input);

        btnInputCrop = findViewById(R.id.input_crop);
        btnInputTexture = findViewById(R.id.input_texture);

        cropList.add("one");
        cropList.add("two");
        cropList.add("three");
        cropList.add("four");
        cropList.add("five");
        cropList.add("six");
        cropList.add("seven");

        StartUpActivity.cropRepository.getAllCrops(this);
        StartUpActivity.cropRepository.getAllTexture(this);

    }
    
    public void onInputCropListener (View view) {
        if (isDataFetched)
            new CustomListDialog(this, cropList, mAlertDialog, this, 1);
    }

    public void onInputTextureListener (View view) {
        if (isDataFetched)
            new CustomListDialog(this, textureList, mAlertDialog, this, 2);
    }

    public void onInputCompleteListener (View view) {

    }

    @Override
    public void onItemClick(int position, int type) {
        if (type == 1){
            btnInputCrop.setText(cropList.get(position));
            crop = cropList.get(position);
            System.out.println(crop);
        }
        else if (type == 2){
            btnInputTexture.setText(textureList.get(position));
            texture = textureList.get(position);
            System.out.println(texture);
        }
    }

    @Override
    public void onAfterFetch(List<String> fetchedData, int type) {
        isDataFetched = true;
        if (type == 1)
            cropList = (ArrayList<String>) fetchedData;
        else if (type == 2)
            textureList = (ArrayList<String>) fetchedData;

    }
}
