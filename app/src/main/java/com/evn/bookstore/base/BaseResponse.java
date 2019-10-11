package com.evn.bookstore.base;

import com.google.gson.annotations.SerializedName;

public class BaseResponse<T> {
    @SerializedName("code")
    public int code;

    @SerializedName("message")
    public String message;

    @SerializedName("data")
    public T data;
}
