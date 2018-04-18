package com.listandgrid.listandgrid.nice_spinner;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.nicespinner.NiceSpinner;
import com.listandgrid.listandgrid.R;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by beixinyuan_android on 2018/4/18.
 */

public class NiceSpinnerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nicespinner);
        NiceSpinner niceSpinner = (NiceSpinner) findViewById(R.id.nice_spinner);
        List<String> dataset = new LinkedList<>(Arrays.asList("One", "Two", "Three", "Four", "Five"));
        niceSpinner.attachDataSource(dataset);
    }
}
