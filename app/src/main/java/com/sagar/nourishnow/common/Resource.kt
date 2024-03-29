package com.sagar.nourishnow.common

sealed class Resource<T>(val data: T? = null, val msg: String? = null){
    class Success<T>(data: T) : Resource<T>(data)
    class Error<T>(msg: String) : Resource<T>(null, msg)
    class Loading<T>(msg: String? = null) : Resource<T>(null, msg)
}