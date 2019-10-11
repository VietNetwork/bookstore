package com.evn.bookstore.module.signin;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.evn.bookstore.R;
import com.evn.bookstore.base.BaseResponse;
import com.evn.bookstore.model.User;
import com.evn.bookstore.module.home.HomeActivity;
import com.evn.bookstore.module.signup.SignUpActivity;

public class SignInActivity extends AppCompatActivity {
    private SignInPresenter signInPresenter;
    private EditText editPhone;
    private EditText editPass;
    private Button btnSignIn;
    private TextView tvStatus;
    private TextView tvSignUpNow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        editPhone = findViewById(R.id.phone);
        editPass = findViewById(R.id.password);
        btnSignIn = findViewById(R.id.signIn);
        tvStatus = findViewById(R.id.signInStatus);
        tvSignUpNow = findViewById(R.id.signUpNow);

        tvSignUpNow.setPaintFlags(tvSignUpNow.getPaintFlags() |
                Paint.UNDERLINE_TEXT_FLAG);

        signInPresenter = new SignInPresenter();

        tvSignUpNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        SignInActivity.this,
                        SignUpActivity.class);
                startActivity(intent);
            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = editPhone.getEditableText().toString();
                String password = editPass.getEditableText().toString();

                doSignIn(phone, password);
            }
        });


    }

    void doSignIn(String phone, String pass) {
        signInPresenter.doSignIn(phone, pass, new SignInPresenter.SignInResponseListener() {
            @Override
            public void onSignInSuccess(BaseResponse<User> data) {
                Intent intent = new Intent(
                        SignInActivity.this,
                        HomeActivity.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onSignFail(Throwable t) {
                tvStatus.setVisibility(View.VISIBLE);
                tvStatus.setText("Sign In That bai");
            }
        });
    }
}
