package com.richards.jonathan.postapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.richards.jonathan.postapp.R
import kotlinx.android.synthetic.main.post_details_layout.*
import org.koin.android.ext.android.inject

class PostDetailsFragment : BaseFragment() {

    private val viewModel: PostViewModel  by inject()

    companion object {

        const val POST_ID_EXTRA = "post id"

        fun createFragment(postId: Int): PostDetailsFragment {
            val bundle = Bundle()

            bundle.putInt(POST_ID_EXTRA, postId)
            val postdetailsFragment = PostDetailsFragment()

            postdetailsFragment.arguments = bundle
            return postdetailsFragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.post_details_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val postId = arguments!!.getInt(POST_ID_EXTRA)

        viewModel.getPostDetails(postId).observe(this, Observer {
            titleText.text = it.title
            bodyText.text = it.body
            usernameText.text = it.username
        })

        viewModel.getCommentCount(postId).observe(this, Observer {
            commentCountText.text = "Number of comments : $it"
        })
    }

}