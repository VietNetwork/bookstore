package com.evn.bookstore.module.signin;

import com.evn.bookstore.BookStoreApp;
import com.evn.bookstore.base.BaseResponse;
import com.evn.bookstore.constant.Constant;
import com.evn.bookstore.model.User;
import com.evn.bookstore.network.BSResponse;
import com.evn.bookstore.network.BookStoreAPI;
import com.evn.bookstore.shared.SharedPrefsUtils;
import com.evn.bookstore.shared.UserRequestBody;

public class SignInPresenter {

    public interface SignInResponseListener {
        void onSignInSuccess(BaseResponse<User> data);
        void onSignFail(Throwable t);
    }

    public void doSignIn(String phone, String password, final SignInResponseListener listener) {
        if (phone.isEmpty() || password.isEmpty()) {
            return;
        }
        BookStoreAPI.getUserService()
                .signIn(UserRequestBody.buildSignInRequestBody(phone, password))
                .enqueue(new BSResponse<BaseResponse<User>>() {
                    @Override
                    public void onData(BaseResponse<User> response) {
                        SharedPrefsUtils.setStringPreference(BookStoreApp.getApp(),
                                Constant.Spref.KEY_TOKEN, response.data.token);

                        listener.onSignInSuccess(response);
                    }

                    @Override
                    public void onError(Throwable t) {
                        listener.onSignFail(t);
                    }
                });
    }
}
