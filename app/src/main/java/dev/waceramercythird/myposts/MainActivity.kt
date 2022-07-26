package dev.waceramercythird.myposts

import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import dev.waceramercythird.myposts.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getPost()
    }
    fun getPost(){
        var apiClient = ApiClient.buildApiClient(ApiInterface::class.java)
        var request = apiClient.getPost()

        request.enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (response.isSuccessful){
                    val posts = response.body()
                    if (posts != null){
                        displayPost(posts)
                    }
//                    var posts = response.body()
//                    Toast.makeText(baseContext, "fetched ${posts!!.size} post",
//                        Toast.LENGTH_LONG).show()
//
//
//                    var postAdapter = PostRvAdapter(posts)
//                    binding.rvPost.layoutManager= LinearLayoutManager(baseContext)
//                    binding.rvPost.adapter  = postAdapter
                }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
            }
        })
    }


fun displayPost(postsList: List<Post>){
    binding.rvPost.layoutManager = LinearLayoutManager(this)
    var postsAdapter = PostRvAdapter (postsList)
    binding.rvPost.adapter = postsAdapter
}

}

