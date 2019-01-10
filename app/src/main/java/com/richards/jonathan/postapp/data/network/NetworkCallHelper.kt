package com.richards.jonathan.postapp.data.network

import androidx.lifecycle.MutableLiveData
import com.richards.jonathan.postapp.data.entity.Resource
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Response

class NetworkCallHelper<DATA : Any> {

    fun makeCall(client: Deferred<Response<DATA>>): MutableLiveData<Resource<DATA>> {
        val result = MutableLiveData<Resource<DATA>>()
        result.value = Resource.loading(null)

        GlobalScope.launch {
            try {

                val response = client.await()
                if (response.isSuccessful) {
                    result.postValue(Resource.success(response.body()))
                }
                result.postValue(Resource.success(response.body()))

            } catch (e: Exception) {
                result.postValue(Resource.error(e.toString(), null))
            }
        }
        return result

    }
}