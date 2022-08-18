package dev.waceramercythird.myposts

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.waceramercythird.myposts.databinding.ActivityCommentBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CommentActivity : AppCompatActivity() {
    lateinit var binding: ActivityCommentBinding
    var postId = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCommentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        obtainPostId()
        fetchPost()
    }
    fun obtainPostId(){
        postId = intent.extras?.getInt("POST_ID")?:0
    }

    fun fetchPost(){
        var apiClient = ApiClient.buildApiClient(ApiInterface::class.java)
        var request = apiClient.getPostId(postId)

        request.enqueue(object: Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                var post = response.body()
                if (post != null){
                    binding.tvTitle1.text = post.title
                    binding.tvBody1.text = post.body
            }
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {

            }

        }
        )






}}