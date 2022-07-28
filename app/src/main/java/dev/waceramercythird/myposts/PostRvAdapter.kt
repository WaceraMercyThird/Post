package dev.waceramercythird.myposts

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import dev.waceramercythird.myposts.databinding.PostListItemBinding


class PostRvAdapter(var postList: List<Post>) :
    RecyclerView.Adapter<PostViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        var binding = PostListItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        var context = holder.itemView.context
        var currentPost = postList.get(position)
        with(holder.binding) {
            tvUserId.text = currentPost.userId.toString()
            tvId.text = currentPost.id.toString()
            tvTitle.text = currentPost.title
            tvBody.text = currentPost.body
//
        }

        holder.binding.imgPost.setOnClickListener{
            Toast
                .makeText(context, "You have clicked on my face", Toast.LENGTH_LONG)
                .show()
        }

    }

    override fun getItemCount(): Int {
        return postList.size
    }
}

class PostViewHolder(var binding: PostListItemBinding) :
    RecyclerView.ViewHolder(binding.root) {



}
