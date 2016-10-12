package com.t3h.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Toast;

import com.example.vaio.fragment.MainActivity;
import com.example.vaio.fragment.R;

/**
 * Created by vaio on 10/4/2016.
 */

public class FragmentChangePassword extends BaseFragment {
    private static final String TAG = "F Change password";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_change_password, container, false);
        initView(view);
        return view;
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

    @Override
    public void onClick(View v) {

        String userName = edtUername.getText().toString();
        String password = edtPassword.getText().toString();

        if (userName.isEmpty() || password.isEmpty()) {
            Toast.makeText(getActivity(), "User name and password must not empty", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!userName.equals(myResource.userName)) {
            Toast.makeText(getActivity(), "Account is not exist", Toast.LENGTH_SHORT).show();
            return;
        }
        myResource.password = password;
        super.onClick(v);
    }
}
