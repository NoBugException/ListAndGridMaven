package com.multilsupport.recycleview;

/**
 * Created by beixinyuan_android on 2018/3/5.
 */

public abstract  class BaseBean {

    //view类型
    private int itemViewType;
    //view名称
    private String name;

    public abstract int getItemViewType();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
