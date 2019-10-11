package com.evn.bookstore.shared;

import com.evn.bookstore.constant.Constant;

import org.json.JSONObject;

import okhttp3.RequestBody;

public class UserRequestBody {
    public static RequestBody buildSignInRequestBody(String phone, String pass) {
        JSONObject params = new JSONObject();
        try {
            params.put("phone", phone);
            params.put("password", pass);
        } catch (Exception e){}

        return RequestBody.create(
                okhttp3.MediaType.parse(Constant.Network.ApplicationJson),
                params.toString());
    }

    public static RequestBody buildSignUpRequestBody(
            String phone, String pass, String displayName) {
        JSONObject params = new JSONObject();
        try {
            params.put("phone", phone);
            params.put("password", pass);
            params.put("displayName", displayName);
        } catch (Exception e){}

        return RequestBody.create(
                okhttp3.MediaType.parse(Constant.Network.ApplicationJson),
                params.toString());
    }
}
