package com.chiachen.bottomnavigationbarpractice.mvp;

import android.content.Context;

/**
 * Created by jianjiacheng on 11/02/2018.
 */

public class MvpPresenter <V extends BaseView>{
    public Context mContext;
    public V mView;

    public void setView(Context context, V view) {
        mContext =context;
        mView = view;
        mView.setPresenter(this);
    }

}
