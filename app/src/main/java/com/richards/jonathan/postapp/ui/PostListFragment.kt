package com.richards.jonathan.postapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.richards.jonathan.postapp.R
import com.richards.jonathan.postapp.data.entity.Post
import com.richards.jonathan.postapp.ui.adapter.PostAdapter
import kotlinx.android.synthetic.main.post_list_layout.*
import org.koin.android.ext.android.inject

class PostListFragment : BaseFragment(), PostAdapter.Companion.PostItemClicked {
    override fun onPostItemClicked(post: Post) {
        //go to post details fragment
        activity.goToDetailsScreen(post.id)
    }

    private val viewModel: PostViewModel  by inject()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.post_list_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //fetch all data
        viewModel.fetchAllData().observe(this, Observer {
            if (it) {
                //then show data we get from our DB
                viewModel.getPostList().observe(this, Observer {
                    if (!it.isNullOrEmpty()) {
                        var postAdapter = PostAdapter(it, this)

                        listView.apply {
                            this.adapter = adapter
                            layoutManager = LinearLayoutManager(activity)
                        }

                    }
                })

            } else {
                //deal with unsuccesful cases here
            }
        })


    }
}