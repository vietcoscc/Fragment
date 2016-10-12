package com.example.vaio.fragment;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.t3h.fragment.FragmentChangePassword;
import com.t3h.fragment.FragmentLogin;
import com.t3h.fragment.FragmentRegister;

public class MainActivity extends AppCompatActivity {
    private Fragment arrFragmen[] = {new FragmentLogin(), new FragmentRegister(), new FragmentChangePassword()};
    private FragmentLogin fragmentLogin = new FragmentLogin();
    private FragmentRegister fragmentRegister = new FragmentRegister();
    private FragmentChangePassword fragmentChangePassword = new FragmentChangePassword();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        initFragment();
        addFragment();
    }

    private void initFragment() {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.panel, fragmentLogin);
        transaction.commit();
    }

    public void changeFragment(Fragment fragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.panel, fragment);
        transaction.commit();
    }

    public void addFragment() {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.panel,fragmentLogin);
        fragmentTransaction.add(R.id.panel,fragmentRegister);
        fragmentTransaction.add(R.id.panel,fragmentChangePassword);
        fragmentTransaction.hide(fragmentRegister);
        fragmentTransaction.hide(fragmentChangePassword);
        fragmentTransaction.commit();
    }

    public void showFragment(Fragment hide,Fragment show) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.hide(hide);
        fragmentTransaction.show(show);
        fragmentTransaction.commit();
    }

    public FragmentLogin getFragmentLogin() {
        return fragmentLogin;
    }

    public FragmentRegister getFragmentRegister() {
        return fragmentRegister;
    }

    public FragmentChangePassword getFragmentChangePassword() {
        return fragmentChangePassword;
    }
}
