package com.evn.bookstore;

import android.app.Application;

public class BookStoreApp extends Application {
    static BookStoreApp app = null;

    @Override
    public void onCreate() {
        super.onCreate();

        app = this;
    }

    public static BookStoreApp getApp() {
        return app;
    }
}
