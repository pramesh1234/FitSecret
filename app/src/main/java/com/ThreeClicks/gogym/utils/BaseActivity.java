package com.ThreeClicks.gogym.utils;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.ThreeClicks.gogym.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }
    public static ArrayAdapter spinnerAdapter(Context context, ArrayList<String> array){
        ArrayAdapter<CharSequence> adapter = new ArrayAdapter(context, android.R.layout.simple_list_item_1,array);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        return adapter;
    }
    public static ArrayAdapter arraySpinnerAdapter(Context context, int array){
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(context,
                array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        return adapter;
    }
}