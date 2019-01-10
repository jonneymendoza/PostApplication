package com.richards.jonathan.postapp.data.network

import androidx.lifecycle.MutableLiveData
import com.richards.jonathan.postapp.data.entity.Resource
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class NetworkCallHelperV2<DATA : Any> {

    fun makeCall(client: Deferred<Response<DATA>>): DATA {


        GlobalScope.launch {
            try {

                val response = client.await()
                if (response.isSuccessful && response.body() != null) {
                    val data=  response.body()!!
                }else{
                    //error
                }


            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        return data

    }
}