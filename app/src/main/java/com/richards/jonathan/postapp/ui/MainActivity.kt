package com.richards.jonathan.postapp.ui

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.richards.jonathan.postapp.R
import com.richards.jonathan.postapp.ui.screen.PostDetailsFragment
import com.richards.jonathan.postapp.ui.screen.PostListFragment

class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity_layout)
        initiateView()
    }

    private fun initiateView() {
        val fragment = PostListFragment()
        supportFragmentManager.beginTransaction()
                .add(R.id.fragment_content, fragment, fragment.javaClass.simpleName).commit()
    }

    fun goToDetailsScreen(postId: String) {
        navigateToFragment(PostDetailsFragment.createFragment(postId))

    }

    /***
     * How i would control and navigate through different screens
     */
//    fun goTo(page: Screen, bundle: Bundle? = null) {
//        when (page) {
//            Screen.POST_LIST_SCREEN -> {
//                navigateToFragment(PostListFragment())
//            }
//            Screen.POST_DETAILS_SCREEN -> {
//
//            }
//
//        }
//    }

    private fun navigateToFragment(fragment: BaseFragment) {
        supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_content, fragment)
                .addToBackStack(null)
                .commit()
    }
}