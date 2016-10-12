package com.t3h.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vaio.fragment.MainActivity;
import com.example.vaio.fragment.R;
import com.t3h.common.MyResource;

/**
 * Created by vaio on 10/9/2016.
 */

public abstract class BaseFragment extends Fragment implements View.OnClickListener{
    protected EditText edtUername;
    protected EditText edtPassword;
    protected Button btnOk;
    protected MyResource myResource;
    @Nullable
    protected void initView(View v){
        edtUername = (EditText) v.findViewById(R.id.username);
        edtPassword = (EditText) v.findViewById(R.id.password);
        btnOk = (Button) v.findViewById(R.id.btn_ok);
        btnOk.setOnClickListener(this);
    }
    protected void setData(String userName,String password){
        edtUername.setText(userName);
        edtPassword.setText(password);
    }

    @Override
    public void onStart() {
        super.onStart();
        myResource = (MyResource) getActivity().getApplicationContext();

    }

    protected void switchFragment(BaseFragment hide, BaseFragment show){
        MainActivity mainActivity = (MainActivity) getActivity();
        mainActivity.showFragment(hide,show);
        String userName= edtUername.getText().toString();
        String password = edtPassword.getText().toString();
        show.setData(userName,password);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_ok :
                switchFragment(getFragmentHide(),getFragmentShow());
                break;
        }
    }
    protected boolean checkInfo(){
        String userName= edtUername.getText().toString();
        String password = edtPassword.getText().toString();

        if(userName.isEmpty() || password.isEmpty()){
            Toast.makeText(getActivity(),"User name and password must not empty",Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
    abstract protected BaseFragment getFragmentHide();
    abstract protected BaseFragment getFragmentShow();
}
