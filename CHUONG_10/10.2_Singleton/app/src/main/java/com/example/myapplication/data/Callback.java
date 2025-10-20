package com.example.myapplication.data;

public abstract class Callback<T> {
    public abstract void onSuccess(T data);
    public abstract void onFailure(Exception e);
}
