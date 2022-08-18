package dev.waceramercythird.myposts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.waceramercythird.myposts.databinding.ActivityCommentBinding
import dev.waceramercythird.myposts.databinding.ActivityFetchPostBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FetchPostActivity : AppCompatActivity() {
    lateinit var binding: ActivityFetchPostBinding
    var postbody = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFetchPostBinding.inflate(layoutInflater)
        setContentView(binding.root)
        obtainPostId()
        fetchPost()
    }
    fun obtainPostId(){
        postbody = intent.extras?.getInt("POST_BODY")?:0
    }

    fun fetchPost(){
        var apiClient = ApiClient.buildApiClient(ApiInterface::class.java)
        var request = apiClient.getPostId(postbody)

        request.enqueue(object: Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                var post = response.body()
                if (post != null){
                    binding.tvTitle2.text = post.title

                    binding.tvBody3.text = post.body
                }
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {

            }

        })
}}