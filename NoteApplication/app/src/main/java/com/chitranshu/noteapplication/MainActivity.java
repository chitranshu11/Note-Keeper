package com.chitranshu.noteapplication;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner_category = findViewById(R.id.spinner_category);

        List<CategoryInfo> categories = DataManager.getInstance().getCategory();
        ArrayAdapter<CategoryInfo> adapterCategory =
                new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,categories);
        adapterCategory.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_category.setAdapter(adapterCategory);
    }
}