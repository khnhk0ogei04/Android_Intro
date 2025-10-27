package com.example.coroutine.resource

import java.lang.Exception

abstract class Result<T> {
    class Success<T>(val data: T) : Result<T>(){}
    class Error<T>(val exception: Exception) : Result<T>() {}
}