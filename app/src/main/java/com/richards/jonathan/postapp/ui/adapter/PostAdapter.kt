package com.richards.jonathan.postapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.richards.jonathan.postapp.R
import com.richards.jonathan.postapp.data.entity.Post
import kotlinx.android.synthetic.main.post_item.view.*

class PostAdapter constructor(private val posts: List<Post>, private val postItemClicked: PostAdapter.Companion.PostItemClicked) :
        RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    companion object {
        interface PostItemClicked {
            fun onPostItemClicked(post: Post)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val postView = LayoutInflater.from(parent.context).inflate(R.layout.post_item, parent, false)

        return PostViewHolder(postView)
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bindView(posts[position])
    }


    inner class PostViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        fun bindView(post: Post) {
            view.titlePost.text = post.title
            view.setOnClickListener {
                postItemClicked.onPostItemClicked(post)
            }
        }
    }
}