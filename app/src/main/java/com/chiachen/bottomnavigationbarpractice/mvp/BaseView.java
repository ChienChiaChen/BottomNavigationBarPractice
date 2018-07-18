package com.chiachen.bottomnavigationbarpractice.mvp;

/**
 * Created by jianjiacheng on 11/02/2018.
 */

public interface BaseView<T> {
    void setPresenter(T presenter);
}
