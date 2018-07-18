package com.chiachen.bottomnavigationbarpractice.mvp;

import android.app.Fragment;

/**
 * Created by jianjiacheng on 11/02/2018.
 */

public class MvpFragment <P extends BasePresenter> extends Fragment implements BaseView<P> {
    private P mPresenter;
    @Override
    public void setPresenter(P presenter) {
        if (null == presenter) return;

        mPresenter = (P) presenter;
        // mapPresenter.setView(this, mapFragment)
    }
}
