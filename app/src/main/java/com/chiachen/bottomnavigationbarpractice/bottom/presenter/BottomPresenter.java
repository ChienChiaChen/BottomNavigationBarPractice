package com.chiachen.bottomnavigationbarpractice.bottom.presenter;

import com.chiachen.bottomnavigationbarpractice.bottom.view.IBottomView;

/**
 * Created by jianjiacheng on 05/01/2018.
 */

public class BottomPresenter implements IBottomPresenter {


    private IBottomView mView;

    public BottomPresenter(IBottomView view) {
        mView = view;
    }

    @Override
    public void init() {
        mView.init();
    }

    @Override
    public void clearTabStatus() {
        mView.clearTabStatus();
    }
}
