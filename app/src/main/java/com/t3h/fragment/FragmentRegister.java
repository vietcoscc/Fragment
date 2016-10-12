package com.t3h.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vaio.fragment.MainActivity;
import com.example.vaio.fragment.R;

/**
 * Created by vaio on 10/4/2016.
 */

public class FragmentRegister extends BaseFragment {
    private static final String TAG = "F Register";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_register, container, false);
        initView(view);
        Log.e(TAG, "on create view ");
        return view;
    }

    @Override
    public void onClick(View v) {
        boolean checkInfo = checkInfo();
        if(checkInfo){
            myResource.userName = edtUername.getText().toString();
            myResource.password = edtPassword.getText().toString();
        }
        super.onClick(v);
    }

    @Override
    protected BaseFragment getFragmentHide() {
        return this;
    }

    @Override
    protected BaseFragment getFragmentShow() {
        MainActivity activity = (MainActivity) getActivity();
        return activity.getFragmentLogin();
    }

}
