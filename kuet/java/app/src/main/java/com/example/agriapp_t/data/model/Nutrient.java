package com.example.agriapp_t.data.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

// no input ready

@Entity(tableName = "nutrient")
public class Nutrient {

    @PrimaryKey
    @NonNull
    private String symbol;

    @ColumnInfo(name = "full_name")
    private String fullName;

    @ColumnInfo(name = "input_title")
    private String inputTitle;

    public Nutrient(String symbol, String fullName, String inputTitle) {
        this.symbol = symbol;
        this.fullName = fullName;
        this.inputTitle = inputTitle;
    }

    @NotNull
    public String getSymbol() {
        return symbol;
    }

    public String getFullName() {
        return fullName;
    }

    public String getInputTitle() {
        return inputTitle;
    }
}
