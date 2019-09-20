package com.example.test;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LoginFragment extends Fragment {

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    private Button summit;
    public EditText phoneNumber;

    static final String TAG = LoginFragment.class.getName();

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(
                R.layout.activity_fragment_phone, container, false);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        summit = view.findViewById(R.id.summit);
        phoneNumber = view.findViewById(R.id.phoneNumber);

        summit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = phoneNumber.getText().toString().trim();
                loginClick(phone);
            }
        });

    }

    public void loginClick(String phone) {
        if (phone.equals("") || phone.length() < 10 || !phone.matches(Utils.MobilePattern)) {
            Toast.makeText(getContext(), getString(R.string.mobile_error), Toast.LENGTH_LONG).show();
        } else {
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.container, FragmentSummit.newInstanceOTP(phone));
            ft.commit();
        }
    }
}
