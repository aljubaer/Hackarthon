package com.example.agriapp_t.ui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.agriapp_t.R;
import com.example.agriapp_t.ui.custom_components.CustomListDialog;
import com.example.agriapp_t.ui.custom_listener.OnListItemClickListener;

import java.util.ArrayList;

public class CropInputActivity extends AppCompatActivity implements OnListItemClickListener {

    public Button btnInputCrop;
    private ArrayList<String> testList = new ArrayList<>();
    private AlertDialog mAlertDialog = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop_input);

        btnInputCrop = findViewById(R.id.input_crop);
        testList.add("one");
        testList.add("two");
        testList.add("three");
        testList.add("four");
        testList.add("five");
        testList.add("six");
        testList.add("seven");

    }

    public void onInputCropListener (View view) {
        new CustomListDialog(this, testList, mAlertDialog, this);
    }


    @Override
    public void onItemClick(int position) {
        btnInputCrop.setText(testList.get(position));
    }
}
