package com.richards.jonathan.postapp.domain.usecase

import androidx.lifecycle.MutableLiveData
import com.richards.jonathan.postapp.data.entity.Resource
import com.richards.jonathan.postapp.domain.PostRepositoryContract

class GetAllDataUseCase constructor(private val postRepository: PostRepositoryContract) {

    /**
     * Fetch all data and store in DB
     */
    fun fetchAllData(): MutableLiveData<Resource<Void>> {
        var callBack = MutableLiveData<Resource<Void>>()

        postRepository.f


        return callBack

    }
}