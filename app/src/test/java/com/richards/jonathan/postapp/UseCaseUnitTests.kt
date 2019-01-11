package com.richards.jonathan.postapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.jraska.livedata.test
import com.richards.jonathan.postapp.TestData.getMockedComments
import com.richards.jonathan.postapp.TestData.getMockedPosts
import com.richards.jonathan.postapp.TestData.getMockedUser
import com.richards.jonathan.postapp.TestModule.testModules
import com.richards.jonathan.postapp.data.network.contract.NetworkControllerContract
import com.richards.jonathan.postapp.domain.usecase.GetAllDataUseCase
import com.richards.jonathan.postapp.domain.usecase.GetCommentCountUseCase
import com.richards.jonathan.postapp.domain.usecase.GetPostDetailsUseCase
import com.richards.jonathan.postapp.domain.usecase.GetPostListUseCase
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.koin.standalone.StandAloneContext.startKoin
import org.koin.standalone.StandAloneContext.stopKoin
import org.koin.standalone.inject
import org.koin.test.KoinTest
import org.mockito.Mockito

/**
 * Unit tests for all the use cases createdó
 */


class UseCaseUnitTests : KoinTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    val getAllDataUseCase: GetAllDataUseCase by inject()
    val getCommentCountUseCase: GetCommentCountUseCase by inject()
    val getPostDetailsUseCase: GetPostDetailsUseCase by inject()
    val getPostListUseCase: GetPostListUseCase by inject()
    val networkController: NetworkControllerContract by inject()

    private val testModulesList = listOf(testModules)

    @Before
    fun setup() {
        startKoin(testModulesList)
    }

    @After
    fun cleanUp() {
        stopKoin()
    }

    @Test
    fun testGetAllData() {
        Mockito.`when`(networkController.getUsers()).thenReturn(GlobalScope.async(Dispatchers.Default,
                CoroutineStart.DEFAULT,
                null, { getMockedUser() }))

        Mockito.`when`(networkController.getPosts()).thenReturn(GlobalScope.async(Dispatchers.Default,
                CoroutineStart.DEFAULT,
                null, { getMockedPosts() }))

        Mockito.`when`(networkController.getComments()).thenReturn(GlobalScope.async(Dispatchers.Default,
                CoroutineStart.DEFAULT,
                null, { getMockedComments() }))

        val fetchDataLiveData = getAllDataUseCase.fetchAllData()

        fetchDataLiveData.test()
                .assertHasValue()
                .assertValue(true)
    }

    @Test
    fun testGetCommentCount() {
        getCommentCountUseCase.getCommentCount("1").test()
                .assertHasValue()
                .assertValue(3)
    }

    @Test
    fun testGetPostList() {
        getPostListUseCase.getPostList().test()
                .assertHasValue()
                .assertValue {
                    it.size == 3
                }
    }

    @Test
    fun testGetPostDetails() {
        getPostDetailsUseCase.getPostDetails("2").test()
                .assertHasValue()
                .assertValue {
                    val postDetails = it
                    postDetails.username == "user3"
                }
    }

}