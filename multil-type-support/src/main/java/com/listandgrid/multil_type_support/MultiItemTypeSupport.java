package com.listandgrid.multil_type_support;

/**
 * Created by Q on 2018/3/1.
 */

public interface MultiItemTypeSupport<T> {
    int getLayoutId(int itemType);

    int getItemViewType(int position, T t);
}
