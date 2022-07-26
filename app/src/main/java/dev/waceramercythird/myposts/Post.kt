package dev.waceramercythird.myposts


data class Post(var userId: Int,
                var id: Int,
                var title: String,
                var body: String
                )
data class Comment(var postId: Int,
                   var id: Int,
                   var name: String,
                   var email: String,
                   var body: String
                   )

//fun <T>compareIds(item1: T, item2: T): T{
//    var output = (item1.toString()+item2.toString())
//    println(output)
//    return item1
//
//}
//
//fun stage(){
//    var post1 = Post(1,1,"abd", "def")
//    var post2 = Post(2,2,"roe", "eer")
//    compareIds(post1, post2)
//}

