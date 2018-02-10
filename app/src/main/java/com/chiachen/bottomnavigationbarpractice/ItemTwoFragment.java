package com.chiachen.bottomnavigationbarpractice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by jianjiacheng on 10/11/2017.
 */

public class ItemTwoFragment extends Fragment {

    public static final String TAG = "ItemTwoFragment";
    private int counter;

    public static Fragment newInstance(){
        return new ItemTwoFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.e("JASON_CHIEN", "\nonCreate");
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e("JASON_CHIEN", "\nonCreateView");
        return inflater.inflate(R.layout.fragment_item_two, container, false);
    }

    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                ((TextView)view.findViewById(R.id.add_text)).setText(""+counter);
            }
        });
        Log.e("JASON_CHIEN", "\nonViewCreated");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e("JASON_CHIEN", "\nonActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e("JASON_CHIEN", "\nonStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e("JASON_CHIEN", "\nonResume");
    }
}
