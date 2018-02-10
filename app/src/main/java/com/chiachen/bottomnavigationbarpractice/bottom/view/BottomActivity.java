package com.chiachen.bottomnavigationbarpractice.bottom.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
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
    private FragmentManager fm;
    private Fragment mFragmentNow;

    private View.OnClickListener mOnTabClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mPresenter.clearTabStatus();
            Fragment selectedFragment = null;
            String tag ="";
            switch (v.getId()) {
                case R.id.bottom_tab_diary:{
                    getDiary().setSelected(true);
                    tag = ItemTwoFragment.TAG;
                    selectedFragment = fm.findFragmentByTag(tag);
                    if (null == selectedFragment) {
                        selectedFragment = ItemTwoFragment.newInstance();
                    }
                }
                break;

                case R.id.bottom_tab_report:{
                    getReport().setSelected(true);
                    tag = ItemThreeFragment.TAG;
                    selectedFragment = fm.findFragmentByTag(tag);
                    if (null == selectedFragment) {
                        selectedFragment = ItemThreeFragment.newInstance();
                    }
                }
                break;

                case R.id.bottom_tab_camera:{
                    getCamera().setSelected(true);
                    tag = ItemFourFragment.TAG;
                    selectedFragment = fm.findFragmentByTag(tag);
                    if (null == selectedFragment) {
                        selectedFragment = ItemFourFragment.newInstance();
                    }
                }
                break;

                case R.id.bottom_tab_coach:{
                    getCoach().setSelected(true);
                    tag = ItemFiveFragment.TAG;
                    selectedFragment = fm.findFragmentByTag(tag);
                    if (null == selectedFragment) {
                        selectedFragment = ItemFiveFragment.newInstance();
                    }
                }
                break;

                case R.id.bottom_tab_more:{
                    getMore().setSelected(true);
                    tag = ItemSixFragment.TAG;
                    selectedFragment = fm.findFragmentByTag(tag);
                    if (null == selectedFragment) {
                        selectedFragment = ItemSixFragment.newInstance();
                    }
                }
                break;
            }

            if (null == selectedFragment) return;
            switchContent(mFragmentNow,selectedFragment,tag);
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
        transaction.add(R.id.frame_layout, mFragmentNow,ItemTwoFragment.TAG);
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

    private void switchContent(Fragment from, Fragment to, String tag) {
        if (mFragmentNow == to) {
            return;
        }

        mFragmentNow = to;
        if (!to.isAdded()) {    // Added or not
            fm.beginTransaction()
                    .hide(from)// Hide current fragment.
                    .add(R.id.frame_layout, to, tag)// Add new fragment
                    .commit();
        } else {
            fm.beginTransaction()
                    .hide(from)// Hide current fragment.
                    .show(to)// Show it
                    .commit();
        }
    }
}
