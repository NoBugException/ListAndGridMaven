package com.listandgrid.listandgrid.pulltozoom;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.listandgrid.listandgrid.R;
import com.listandgrid.listandgrid.pulltozoom.recyclerview.PullToZoomRecyclerActivity;

/**
 * Created by beixinyuan_android on 2018/4/23.
 */

public class PullToZoomActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pulltizoomview);

        findViewById(R.id.btn_list).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PullToZoomActivity.this, PullToZoomListActivity.class));
            }
        });

        findViewById(R.id.btn_scroll).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PullToZoomActivity.this, PullToZoomScrollActivity.class));
            }
        });

        findViewById(R.id.btn_recycler_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PullToZoomActivity.this, PullToZoomRecyclerActivity.class));
            }
        });
    }

}
