package com.richards.jonathan.postapp.domain.usecase

import androidx.lifecycle.LiveData
import com.richards.jonathan.postapp.domain.PostRepositoryContract

class GetAllDataUseCase constructor(private val postRepository: PostRepositoryContract) {

    /**
     * Fetch all data and store in DB
     */
    fun fetchAllData(): LiveData<Boolean> {
        return postRepository.fetchAndSaveData()
    }
}