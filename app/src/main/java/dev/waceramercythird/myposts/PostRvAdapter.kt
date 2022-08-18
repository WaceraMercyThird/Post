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
            tvUserId3.text = currentPost.userId.toString()
            tvId2.text = currentPost.id.toString()
            tvTitle3.text = currentPost.title
            tvBody3.text = currentPost.body
            cvPost2.setOnClickListener{
                var intent = Intent(context, CommentActivity::class.java)
                intent.putExtra("POST_ID", currentPost.id)
                context.startActivity(intent)
            }
            tvBody3.setOnClickListener{
                var intent = Intent(context, FetchPostActivity::class.java)
                intent.putExtra("POST_BODY", currentPost.body)
                context.startActivity(intent)
            }

//
        }

        holder.binding.imgPost.setOnClickListener{
            Toast
                .makeText(context, "You have clicked on my face", Toast.LENGTH_LONG)
                .show()
        }
        holder.binding.tvBody3.setOnClickListener{
            Toast
                .makeText(context, "You have clicked on comment", Toast.LENGTH_LONG)
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
