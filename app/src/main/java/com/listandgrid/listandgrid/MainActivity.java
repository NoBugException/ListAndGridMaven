package com.listandgrid.listandgrid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.listandgrid.listandgrid.flabbyview.FlabbyActivity;
import com.listandgrid.listandgrid.nice_spinner.NiceSpinnerActivity;
import com.listandgrid.listandgrid.parallax.ParallaxActivity;
import com.listandgrid.listandgrid.pulltozoom.PullToZoomActivity;
import com.listandgrid.listandgrid.stickyheader.StickyHeaderActivity;
import com.listandgrid.listandgrid.swipedismissrecyclerview.SwipeDismissRecyclerActivity;
import com.multilsupport.recycleview.BaseBean;
import com.multilsupport.recycleview.CommonViewHolder;
import com.multilsupport.recycleview.MultiItemCommonAdapter;
import com.multilsupport.recycleview.MultiItemTypeSupport;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.materialdesign_recycle);


        List<BaseBean> mDatas = new ArrayList<>();
        BBaseBean bBaseBean1 = new BBaseBean();
        bBaseBean1.setFlag(1);
        bBaseBean1.setName("滑动删除的recycleview");
        mDatas.add(bBaseBean1);

        BBaseBean bBaseBean2 = new BBaseBean();
        bBaseBean2.setFlag(2);
        bBaseBean2.setName("FlabbyLayout");
        mDatas.add(bBaseBean2);

        BBaseBean bBaseBean3 = new BBaseBean();
        bBaseBean3.setFlag(3);
        bBaseBean3.setName("recycleview增加头部");
        mDatas.add(bBaseBean3);

        BBaseBean bBaseBean4 = new BBaseBean();
        bBaseBean4.setFlag(4);
        bBaseBean4.setName("NiceSpinner");
        mDatas.add(bBaseBean4);

        BBaseBean bBaseBean5 = new BBaseBean();
        bBaseBean5.setFlag(5);
        bBaseBean5.setName("ParallaxScollListView");
        mDatas.add(bBaseBean5);

        BBaseBean bBaseBean6 = new BBaseBean();
        bBaseBean6.setFlag(6);
        bBaseBean6.setName("PullToZoomView");
        mDatas.add(bBaseBean6);

        LinearLayoutManager layoutmanager = new LinearLayoutManager(this);
        //设置RecyclerView 布局
        mRecyclerView.setLayoutManager(layoutmanager);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        mRecyclerView.setAdapter(new MultiItemCommonAdapter<BaseBean>(this, mDatas, new MultiItemTypeSupport() {
            @Override
            public int getLayoutId(int itemType) {
                int layoutId = -1;
                switch (itemType){
                    case MaterialItemViewType.BASE:
                        layoutId =  R.layout.item_base;
                        break;
                }
                return layoutId;
            }

            @Override
            public int getItemViewType(int position, Object o) {
                return MaterialItemViewType.BASE;
            }
        }) {
            @Override
            public void convert(CommonViewHolder holder, BaseBean baseBean) {
                //填充
                TextView type;
                TextView mame;
                switch (baseBean.getItemViewType()){
                    case MaterialItemViewType.BASE:
                        final BBaseBean bbaseBean = (BBaseBean) baseBean;
                        mame = holder.getView(R.id.id_item_materialname);
                        mame.setText(bbaseBean.getName());
                        type = holder.getView(R.id.id_item_materialtype);
                        type.setText(String.valueOf(bbaseBean.getItemViewType()));
                        holder.setOnClickListener(R.id.root, new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                if(bbaseBean.getFlag() == 1){
                                    startActivity(new Intent(MainActivity.this, SwipeDismissRecyclerActivity.class));
                                }else if(bbaseBean.getFlag() == 2){
                                    startActivity(new Intent(MainActivity.this, FlabbyActivity.class));
                                }else if(bbaseBean.getFlag() == 3){
                                    startActivity(new Intent(MainActivity.this, StickyHeaderActivity.class));
                                }else if(bbaseBean.getFlag() == 4){
                                    startActivity(new Intent(MainActivity.this, NiceSpinnerActivity.class));
                                }else if(bbaseBean.getFlag() == 5){
                                    startActivity(new Intent(MainActivity.this, ParallaxActivity.class));
                                }else if(bbaseBean.getFlag() == 6){
                                    startActivity(new Intent(MainActivity.this, PullToZoomActivity.class));
                                }
                            }
                        });
                        break;
                }
            }
        });
    }
}
