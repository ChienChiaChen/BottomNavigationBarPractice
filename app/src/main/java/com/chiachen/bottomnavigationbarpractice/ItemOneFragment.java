package com.chiachen.bottomnavigationbarpractice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by jianjiacheng on 10/11/2017.
 */

public class ItemOneFragment extends Fragment {
    private Button tab1,tab2, tab3;

    private View.OnClickListener mListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Fragment selectedFragment = null;
            switch (v.getId()) {
                case R.id.tab1:{
                    selectedFragment = new ItemFourFragment();
                    break;
                }
                case R.id.tab2:{
                    selectedFragment = new ItemFiveFragment();
                    break;
                }
                case R.id.tab3:{
                    selectedFragment = new ItemSixFragment();
                    break;
                }
            }

            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.child_frame_layout, selectedFragment);
            transaction.commit();
        }
    };

    public static Fragment newInstance() {
        return new ItemOneFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_item_one, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tab1 = view.findViewById(R.id.tab1);
        tab2 = view.findViewById(R.id.tab2);
        tab3 = view.findViewById(R.id.tab3);
        tab1.setOnClickListener(mListener);
        tab2.setOnClickListener(mListener);
        tab3.setOnClickListener(mListener);

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.child_frame_layout, new ItemFourFragment());
        transaction.commit();
    }
}
