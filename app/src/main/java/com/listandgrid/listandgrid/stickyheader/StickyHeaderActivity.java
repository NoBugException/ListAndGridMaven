package com.listandgrid.listandgrid.stickyheader;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.stickyheaders.DrawOrder;
import com.example.stickyheaders.OnHeaderClickListener;
import com.example.stickyheaders.StickyHeadersBuilder;
import com.example.stickyheaders.StickyHeadersItemDecoration;
import com.listandgrid.listandgrid.R;
import com.listandgrid.listandgrid.stickyheader.adapters.BigramHeaderAdapter;
import com.listandgrid.listandgrid.stickyheader.adapters.InitialHeaderAdapter;
import com.listandgrid.listandgrid.stickyheader.adapters.PersonAdapter;
import com.listandgrid.listandgrid.stickyheader.data.PersonDataProvider;

/**
 * Created by beixinyuan_android on 2018/4/18.
 */

public class StickyHeaderActivity extends ActionBarActivity implements OnHeaderClickListener {

    private RecyclerView list;
    private StickyHeadersItemDecoration top;
    private StickyHeadersItemDecoration overlay;
    private PersonDataProvider personDataProvider;
    private PersonAdapter personAdapter;
    private Spinner samplesSpinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stickyheader);

        list = (RecyclerView)findViewById(R.id.list);

        list.setLayoutManager(new LinearLayoutManager(StickyHeaderActivity.this, LinearLayoutManager.VERTICAL, false));

        personDataProvider = new PersonDataProvider();
        personAdapter = new PersonAdapter(this, personDataProvider);

        top = new StickyHeadersBuilder()
                .setAdapter(personAdapter)
                .setRecyclerView(list)
                .setStickyHeadersAdapter(new BigramHeaderAdapter(personDataProvider.getItems()))
                .setOnHeaderClickListener(this)
                .setSticky(true)//true:header划到顶部时，动态停止并切换；false：无动态效果
                .setDrawOrder(DrawOrder.OverItems)//true：header在上面；false：header在下面
                .build();


        overlay = new StickyHeadersBuilder()
                .setAdapter(personAdapter)
                .setRecyclerView(list)
                .setStickyHeadersAdapter(new InitialHeaderAdapter(personDataProvider.getItems()), true)
                .build();

        list.setAdapter(personAdapter);
        list.removeItemDecoration(overlay);
        list.addItemDecoration(top);


        // Inflate a menu to be displayed in the toolbar
//        toolbar.inflateMenu(R.menu.main);

        // Set an OnMenuItemClickListener to handle menu item clicks
//        toolbar.setOnMenuItemClickListener(
//                new Toolbar.OnMenuItemClickListener() {
//                    @Override
//                    public boolean onMenuItemClick(MenuItem item) {
//                        if (item.getItemId() == R.id.add_item) {
//                            int addedPosition = personDataProvider.insertAfter(list.getChildPosition(list.getChildAt(0)));
//                            personAdapter.notifyItemInserted(addedPosition);
//                            return true;
//                        }
//                        else if (item.getItemId() == R.id.github) {
//                            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/eowise/recyclerview-stickyheaders/"));
//                            startActivity(browserIntent);
//                            return true;
//                        }
//
//                        return false;
//                    }
//                }
//        );

//        samplesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                if (i == 0) {
//                    list.setAdapter(personAdapter);
//                    list.removeItemDecoration(overlay);
//                    list.addItemDecoration(top);
//                }
//                else {
//                    list.setAdapter(personAdapter);
//                    list.removeItemDecoration(top);
//                    list.addItemDecoration(overlay);
//                }
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });

    }

    @Override
    public void onHeaderClick(View header, long headerId) {
        TextView text = (TextView)header.findViewById(R.id.title);
        Toast.makeText(getApplicationContext(), "Click on " + text.getText(), Toast.LENGTH_SHORT).show();
    }
}
