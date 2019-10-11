package com.evn.bookstore.network;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class BSResponse<T> implements Callback<T> {
    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.isSuccessful()) {
            onData(response.body());
        } else {
            onError(new Exception("loi gi do"));
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        onError(t);
    }

    public abstract void onData(T data);
    public abstract void onError(Throwable t);
}