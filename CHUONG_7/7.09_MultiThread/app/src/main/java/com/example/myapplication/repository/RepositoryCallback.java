package com.example.myapplication.repository;

import com.example.myapplication.resource.Result;

public interface RepositoryCallback<T> {
    void onComplete (Result<T> result);
}
