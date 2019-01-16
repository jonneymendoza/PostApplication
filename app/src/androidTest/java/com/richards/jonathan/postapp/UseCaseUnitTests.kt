package com.richards.jonathan.postapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.jraska.livedata.test
import com.richards.jonathan.postapp.TestData.getMockedComments
import com.richards.jonathan.postapp.TestData.getMockedPosts
import com.richards.jonathan.postapp.TestData.getMockedUser
import com.richards.jonathan.postapp.TestModule.testModules
import com.richards.jonathan.postapp.data.database.PostDatabase
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
import org.junit.runner.RunWith
import org.koin.standalone.StandAloneContext.loadKoinModules
import org.koin.standalone.inject
import org.koin.test.KoinTest
import org.mockito.Mockito

/**
 * Unit tests for all the use cases created
 */

@RunWith(AndroidJUnit4::class)
class UseCaseUnitTests : KoinTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    val getAllDataUseCase: GetAllDataUseCase by inject()
    val getCommentCountUseCase: GetCommentCountUseCase by inject()
    val getPostDetailsUseCase: GetPostDetailsUseCase by inject()
    val getPostListUseCase: GetPostListUseCase by inject()
    val networkController: NetworkControllerContract by inject()
    val postDatabase: PostDatabase by inject()


    /***
     * Load mocked dependencies and load mocked data into the dataase
     */
    @Before
    fun setup() {
        loadKoinModules(listOf(testModules(InstrumentationRegistry.getInstrumentation().context)))
        loadDataIntoDb()
    }

    @After
    fun cleanUp() {
        postDatabase.close()
    }


    private fun loadDataIntoDb() {
        Mockito.`when`(networkController.getUsers()).thenReturn(GlobalScope.async(Dispatchers.Default,
                CoroutineStart.DEFAULT,
                null, { getMockedUser() }))

        Mockito.`when`(networkController.getPosts()).thenReturn(GlobalScope.async(Dispatchers.Default,
                CoroutineStart.DEFAULT,
                null, { getMockedPosts() }))

        Mockito.`when`(networkController.getComments()).thenReturn(GlobalScope.async(Dispatchers.Default,
                CoroutineStart.DEFAULT,
                null, { getMockedComments() }))

        //Load data into the database
        val fetchDataLiveData = getAllDataUseCase.fetchAllData()

        fetchDataLiveData.test()
                .awaitValue()
                .assertHasValue()
                .assertValue(true)
    }

    @Test
    fun testGetCommentCount() {
        getCommentCountUseCase.getCommentCount("1").test()
                .awaitValue()
                .assertHasValue()
                .assertValue(3)
    }

    @Test
    fun testGetPostList() {
        getPostListUseCase.getPostList().test()
                .awaitValue()
                .assertHasValue()
                .assertValue {
                    it.size == 3
                }
    }

    @Test
    fun testGetPostDetails() {
        getPostDetailsUseCase.getPostDetails("2").test()
                .awaitValue()
                .assertHasValue()
                .assertValue {
                    val postDetails = it
                    postDetails.username == "marky"
                }
    }

}