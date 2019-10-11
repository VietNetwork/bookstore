package com.evn.bookstore.model;

import com.google.gson.annotations.SerializedName;

/*
{
    "code": 200,
    "message": "OK",
    "data": {
        "displayName": "Ryan Nguyen",
        "avatar": "https://static2.yan.vn/YanThumbNews/2167221/201711/300x300_3c55ff92-b133-4729-8ce3-2f3d881d5841.jpg",
        "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiJlMjRkNjkxZC0wYWE3LTQ4NTItYmIzNC1mOWEyNzkwZTA2NGIiLCJyb2xlIjoiTUVNQkVSIiwicGhvbmVOdW5iZXIiOiIwOTczOTAxNzg5IiwiZXhwIjoxNTgzNjUwNjQwfQ.BHXmm5lDAUgBCJgTl4TIVlp7hXx1fW6QmdVlVRXhobU"
    }
}
 */
public class User {
    @SerializedName("displayName")
    public String displayName;

    @SerializedName("avatar")
    public String avatar;

    @SerializedName("token")
    public String token;
}
