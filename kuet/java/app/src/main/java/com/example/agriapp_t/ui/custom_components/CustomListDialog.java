package com.example.agriapp_t.ui.custom_components;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.agriapp_t.ui.custom_listener.OnListItemClickListener;

import java.util.ArrayList;

public class CustomListDialog {

    private Context context;
    private ArrayList<String> values;
    private ArrayList<String> currentValueList;
    private AlertDialog dialog = null;
    private int textLength = 0;
    private String selectedText = "";
    private OnListItemClickListener itemClickListener;


    public CustomListDialog(Context context, ArrayList<String> values, AlertDialog dialog, OnListItemClickListener itemClickListener) {
        this.dialog = dialog;
        this.context = context;
        this.values = values;
        this.itemClickListener = itemClickListener;
        createView();
    }

    private void createView() {
        AlertDialog.Builder mDialog = new AlertDialog.Builder(context);
        final ListView listView = new ListView(context);
        currentValueList = new ArrayList<>();
        currentValueList = (ArrayList<String>) values.clone();
        LinearLayout layout = new LinearLayout(context);
        layout.setOrientation(LinearLayout.VERTICAL);
        CropSelectListAdapter arrayAdapter = new CropSelectListAdapter((Activity) context, currentValueList);
        listView.setAdapter(arrayAdapter);
        layout.addView(listView);
        mDialog.setView(layout);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                            @Override
                                            public void onItemClick (AdapterView< ? > adapter, View view, int position, long arg){
//                                                if (currentValueList.size() > 0 && position >= 0 && position < currentValueList.size())
//                                                    selectedText = currentValueList.get(position);
//                                                else selectedText = values.get(position);
//                                                textView.setText(selectedText);
                                                itemClickListener.onItemClick(position);
                                                dialog.dismiss();
                                            }
                                        }
        );

        mDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        dialog = mDialog.show();

    }
}
