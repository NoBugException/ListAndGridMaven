package com.listandgrid.listandgrid;

import com.listandgrid.multil_type_support.BaseBean;

/**
 * Created by beixinyuan_android on 2018/3/29.
 */

public class BBaseBean extends BaseBean {

    private int flag;

    @Override
    public int getItemViewType() {
        return MaterialItemViewType.BASE;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
