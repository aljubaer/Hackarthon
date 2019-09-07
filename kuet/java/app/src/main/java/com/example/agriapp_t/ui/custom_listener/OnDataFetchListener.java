package com.example.agriapp_t.ui.custom_listener;

import java.util.List;

public interface OnDataFetchListener {
    void onAfterFetch(List<String> fetchedData, int type);
}
