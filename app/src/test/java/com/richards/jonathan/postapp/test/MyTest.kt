package com.richards.jonathan.postapp.test

import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Test
import org.koin.dsl.module.module
import org.koin.standalone.StandAloneContext.startKoin
import org.koin.standalone.get
import org.koin.standalone.inject
import org.koin.test.KoinTest

class MyTest : KoinTest {

    class ComponentA
    class ComponentB(val a: ComponentA)

    val appModule = module {
        single { ComponentA() }
        single { ComponentB(get()) }
    }

    // Lazy inject property
    val componentB : ComponentB by inject()

    @Test
    fun `should inject my components`() {
        startKoin(listOf(appModule))

        // directly request an instance
        val componentA = get<ComponentA>()

        assertNotNull(componentA)
        assertEquals(componentA, componentB.a)
    }
}