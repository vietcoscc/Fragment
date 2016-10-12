package com.t3h.fragment;

import android.app.Fragment;
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

public class FragmentLogin extends BaseFragment{
    private static final String TAG = "F Login";

    private TextView tvRegister;
    private TextView tvChangePassword;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_login,container,false);
        initView(view);
        return view;
    }
    protected void initView(View v){
        super.initView(v);
        tvRegister= (TextView) v.findViewById(R.id.register);
        tvChangePassword = (TextView) v.findViewById(R.id.change_password);
        tvRegister.setOnClickListener(this);
        tvChangePassword.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
//        super.onClick(v);
        MainActivity activity = (MainActivity) getActivity();
        switch (v.getId()){
            case R.id.register:
                switchFragment(getFragmentHide(),activity.getFragmentRegister());
                break;
            case R.id.change_password:
                switchFragment (getFragmentHide(),activity.getFragmentChangePassword());
                break;
            case R.id.btn_ok :
                if(!checkInfo()){
                    return;
                }
                if(myResource.userName.equals(edtUername.getText().toString())&& myResource.password.equals(edtPassword.getText().toString())){
                    Toast.makeText(getActivity(),"Login success",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getActivity(),"Login fail",Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    @Override
    protected BaseFragment getFragmentHide() {
        return this;
    }

    @Override
    protected BaseFragment getFragmentShow() {
        MainActivity mainActivity = (MainActivity) getActivity();
        return mainActivity.getFragmentRegister();
    }
}
