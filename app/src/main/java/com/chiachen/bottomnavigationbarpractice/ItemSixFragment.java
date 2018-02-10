package com.chiachen.bottomnavigationbarpractice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by jianjiacheng on 10/11/2017.
 */

public class ItemSixFragment extends Fragment {
    public static final String TAG = "ItemSixFragment";

    public static Fragment newInstance() {
        return new ItemSixFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_item_six, container, false);
    }
}
