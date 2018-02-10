package com.chiachen.bottomnavigationbarpractice.bottom.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.chiachen.bottomnavigationbarpractice.ItemFiveFragment;
import com.chiachen.bottomnavigationbarpractice.ItemFourFragment;
import com.chiachen.bottomnavigationbarpractice.ItemSixFragment;
import com.chiachen.bottomnavigationbarpractice.ItemThreeFragment;
import com.chiachen.bottomnavigationbarpractice.ItemTwoFragment;
import com.chiachen.bottomnavigationbarpractice.R;
import com.chiachen.bottomnavigationbarpractice.bottom.presenter.BottomPresenter;
import com.chiachen.bottomnavigationbarpractice.bottom.presenter.IBottomPresenter;

public class BottomActivity extends AppCompatActivity implements IBottomView {

    private IBottomPresenter mPresenter;
    FragmentManager fm;
    private Fragment mFragmentNow;
    
    private View.OnClickListener mOnTabClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mPresenter.clearTabStatus();
            Fragment selectedFragment = null;
            switch (v.getId()) {
                case R.id.bottom_tab_diary:{
                    getDiary().setSelected(true);
                    selectedFragment = ItemTwoFragment.newInstance();
                    break;
                }

                case R.id.bottom_tab_report:{
                    getReport().setSelected(true);
                    selectedFragment = ItemThreeFragment.newInstance();
                    break;
                }

                case R.id.bottom_tab_camera:{
                    getCamera().setSelected(true);
                    selectedFragment = ItemFourFragment.newInstance();
                    break;
                }

                case R.id.bottom_tab_coach:{
                    getCoach().setSelected(true);
                    selectedFragment = ItemFiveFragment.newInstance();
                    break;
                }

                case R.id.bottom_tab_more:{
                    getMore().setSelected(true);
                    selectedFragment = ItemSixFragment.newInstance();
                    break;
                }
            }

            if (null == selectedFragment) return;
            switchContent(mFragmentNow,selectedFragment);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new BottomPresenter(this);
        mPresenter.init();
    }

    @Override
    public void init() {
        setContentView(R.layout.activity_main_bottom);


        getDiary().setOnClickListener(mOnTabClickListener);
        getReport().setOnClickListener(mOnTabClickListener);
        getCamera().setOnClickListener(mOnTabClickListener);
        getCoach().setOnClickListener(mOnTabClickListener);
        getMore().setOnClickListener(mOnTabClickListener);
        setDefaultFragment();
    }

    private void setDefaultFragment() {
        fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        mFragmentNow = ItemTwoFragment.newInstance();
        transaction.add(R.id.frame_layout, mFragmentNow);
        transaction.commit();
    }

    @Override
    public void clearTabStatus() {
        getDiary().setSelected(false);
        getReport().setSelected(false);
        getCamera().setSelected(false);
        getCoach().setSelected(false);
        getMore().setSelected(false);
    }

    private View getMore() {
        return findViewById(R.id.bottom_tab_more);
    }

    private View getCamera() {
        return findViewById(R.id.bottom_tab_camera);
    }

    private View getCoach() {
        return findViewById(R.id.bottom_tab_coach);
    }

    private View getReport() {
        return findViewById(R.id.bottom_tab_report);
    }

    private View getDiary() {
        return findViewById(R.id.bottom_tab_diary);
    }

    private void switchContent(Fragment from, Fragment to) {
        if (mFragmentNow == to) {
            return;
        }

        mFragmentNow = to;
        FragmentTransaction transaction = fm.beginTransaction();
        if (!to.isAdded()) {    // 先判断是否被add过
            Log.e("JASON_CHIEN", "\nis Not Added");
            transaction.hide(from).add(R.id.frame_layout, to).commit(); // 隐藏当前的fragment，add下一个到Activity中
        } else {
            Log.e("JASON_CHIEN", "\nis Added");
            transaction.hide(from).show(to).commit(); // 隐藏当前的fragment，显示下一个
        }
    }
}
