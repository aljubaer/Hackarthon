package com.example.agriapp_t.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.agriapp_t.R;
import com.example.agriapp_t.data.repository.CropRepository;

public class StartUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_up);

        CropRepository cropRepository = new CropRepository(getApplication());
    }
}
