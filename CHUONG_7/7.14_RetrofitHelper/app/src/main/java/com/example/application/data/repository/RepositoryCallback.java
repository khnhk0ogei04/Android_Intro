package com.example.application.data.repository;

import com.example.application.data.resource.Result;

public interface RepositoryCallback<T> {
    void onComplete(Result<T> result);
}
