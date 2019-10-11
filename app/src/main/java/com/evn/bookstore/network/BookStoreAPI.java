package com.evn.bookstore.network;

import com.evn.bookstore.network.service.ProductService;
import com.evn.bookstore.network.service.UserService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BookStoreAPI {
    static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://10.173.26.186:8000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static UserService getUserService() {
        return retrofit.create(UserService.class);
    }

    public static ProductService GetProductService() {
        return retrofit.create(ProductService.class);
    }

}