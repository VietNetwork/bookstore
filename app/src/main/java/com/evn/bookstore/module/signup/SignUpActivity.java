package com.evn.bookstore.module.signup;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.evn.bookstore.R;
import com.evn.bookstore.base.BaseResponse;
import com.evn.bookstore.model.User;
import com.evn.bookstore.module.home.HomeActivity;

public class SignUpActivity extends AppCompatActivity {
    private EditText editPhone;
    private EditText editPass;
    private EditText editDisplayName;
    private Button btnSignUp;
    private TextView tvStatus;

    private SignUpPresenter signUpPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        signUpPresenter = new SignUpPresenter();

        editPhone = findViewById(R.id.phone);
        editPass = findViewById(R.id.password);
        editDisplayName = findViewById(R.id.displayName);

        btnSignUp = findViewById(R.id.signUp);
        tvStatus = findViewById(R.id.signInStatus);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = editPhone.getEditableText().toString();
                String password = editPass.getEditableText().toString();
                String displayName = editDisplayName.getEditableText().toString();

                doSignUp(phone, password, displayName);
            }
        });
    }

    private ProgressDialog dialog;
    private void doSignUp(final String phone, final String password, final String displayName) {
        dialog = ProgressDialog.show(this, "",
                "Loading. Please wait...", true);
        dialog.show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                signUpPresenter.doSignUp(phone, password, displayName,
                        new SignUpPresenter.SignUpResponseListener() {
                            @Override
                            public void onSignUpSuccess(BaseResponse<User> data) {
                                dialog.dismiss();
                                Intent intent = new Intent(
                                        SignUpActivity.this,
                                        HomeActivity.class);
                                startActivity(intent);
                                finish();
                            }

                            @Override
                            public void onSignUpFail(Throwable t) {
                                dialog.dismiss();
                                tvStatus.setVisibility(View.VISIBLE);
                                tvStatus.setText("Sign Up That bai");
                            }
                        });
            }
        }, 3000);


    }
}
