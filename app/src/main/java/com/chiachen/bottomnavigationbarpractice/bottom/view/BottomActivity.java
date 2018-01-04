package com.chiachen.bottomnavigationbarpractice.bottom.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.chiachen.bottomnavigationbarpractice.R;
import com.chiachen.bottomnavigationbarpractice.bottom.presenter.BottomPresenter;
import com.chiachen.bottomnavigationbarpractice.bottom.presenter.IBottomPresenter;

public class BottomActivity extends AppCompatActivity implements IBottomView {

    private IBottomPresenter mPresenter;
    private View.OnClickListener mOnTabClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mPresenter.clearTabStatus();
            switch (v.getId()) {
                case R.id.bottom_tab_diary:{
                    getDiary().setSelected(true);
                    break;
                }

                case R.id.bottom_tab_report:{
                    getReport().setSelected(true);
                    break;
                }

                case R.id.bottom_tab_camera:{
                    getCamera().setSelected(true);
                    break;
                }

                case R.id.bottom_tab_coach:{
                    getCoach().setSelected(true);
                    break;
                }

                case R.id.bottom_tab_more:{
                    getMore().setSelected(true);
                    break;
                }
            }
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
}
