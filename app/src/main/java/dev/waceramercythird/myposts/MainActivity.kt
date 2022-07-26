package dev.waceramercythird.myposts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getPost()
    }
    fun getPost(){
        var retrofit = ApiClient.buildApiClient(ApiInterface::class.java)
        var request = retrofit.getPost()

        request.enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (response.isSuccessful){
                    val posts = response.body()
                    Toast.makeText(baseContext, "fetched ${posts!!.size} post",
                        Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {

            }
        })
    }
}