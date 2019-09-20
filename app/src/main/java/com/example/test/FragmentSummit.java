package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentSummit extends Fragment {
    Button summitOTP_button;
    private TextView number;
    private EditText oTP_editText;

    public static FragmentSummit newInstanceOTP(String phone) {
        FragmentSummit fragmentSummit = new FragmentSummit();
        Bundle args = new Bundle();
        args.putString(IntentConstant.PHONE, phone);
        fragmentSummit.setArguments(args);
        return fragmentSummit;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(
                R.layout.activity_fragment_otp, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        number = view.findViewById(R.id.phone_number_textView);
        oTP_editText = view.findViewById(R.id.oTP_editText);
        summitOTP_button = view.findViewById(R.id.summitOTP_button);
        String login_number= getArguments().getString(IntentConstant.PHONE);
        number.setText(login_number);
        summitOTP_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String otp = oTP_editText.getText().toString().trim();
                summitOTPCalled(otp);
            }
        });
    }
    void summitOTPCalled(String otp) {
        if (otp.equals("") || otp.length() < 4) {
            Toast.makeText(getContext(), getString(R.string.otp_error), Toast.LENGTH_LONG).show();
        } else {
            Intent intent = new Intent(getActivity().getBaseContext(), HomeActivity.class);
            getActivity().startActivity(intent);
        }
    }

}
