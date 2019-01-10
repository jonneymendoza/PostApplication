package com.richards.jonathan.postapp.data.entity

interface  DataResponse<T>{
    fun getResponseData(): T
}