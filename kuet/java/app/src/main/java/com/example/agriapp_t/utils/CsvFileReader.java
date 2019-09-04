package com.example.agriapp_t.utils;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CsvFileReader {
    public List<String[]> read(String fileName) {
        Context context = SuperAppApplication.getContext();
        AssetManager manager = context.getAssets();
        List<String[]> data = new ArrayList<>();
        InputStream inStream = null;
        try {
            inStream = manager.open(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedReader buffer = new BufferedReader(new InputStreamReader(inStream));
        String line = "";
        try {
            while ((line = buffer.readLine()) != null) {
                String[] str = line.split(",");
                data.add(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
