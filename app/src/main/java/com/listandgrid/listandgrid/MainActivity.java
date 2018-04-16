package com.listandgrid.listandgrid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.listandgrid.multil_type_support.BaseBean;
import com.listandgrid.multil_type_support.CommonViewHolder;
import com.listandgrid.multil_type_support.MultiItemCommonAdapter;
import com.listandgrid.multil_type_support.MultiItemTypeSupport;

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
        bBaseBean1.setName("111");
        mDatas.add(bBaseBean1);

        BBaseBean bBaseBean2 = new BBaseBean();
        bBaseBean2.setFlag(2);
        bBaseBean2.setName("222");
        mDatas.add(bBaseBean2);

        BBaseBean bBaseBean3 = new BBaseBean();
        bBaseBean3.setFlag(3);
        bBaseBean3.setName("333");
        mDatas.add(bBaseBean3);

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

                                }
                            }
                        });
                        break;
                }
            }
        });
    }
}
