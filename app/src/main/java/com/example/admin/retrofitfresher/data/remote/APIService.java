package com.example.admin.retrofitfresher.data.remote;

import com.example.admin.retrofitfresher.data.model.Post;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Admin on 12/1/2017.
 */

public interface APIService {

    @POST("/posts")
    @FormUrlEncoded
    Call<Post> savePost(@Field("title") String title, @Field("body") String body, @Field("userid") long userid);

    /**
     *
     * we have a method called savePost().
     * On top of the method is the @POST annotation,
     *  - which indicates that we want to execute a POST request when this method is called.
     *  The argument value for the @POST annotation is the endpoint—which is /posts.
     * So the full URL will be http://jsonplaceholder.typicode.com/posts.
     *
     * @FormUrlEncoded? This will indicate that the request will have its MIME type
     * (a header field that identifies the format of
     * the body of an HTTP request or response) set to application/x-www-form-urlencoded
     * and also that its field names and values will be UTF-8 encoded before being URI-encoded.
     *
     * The @Field("key") annotation with parameter name should match the name that the API expects.
     *
     * Retrofit implicitly converts the values to strings using String.valueOf(Object),
     * and the strings are then form URL encoded. null values are ignored.
     *
     *
     * For example, calling APIService.savePost("My Visit To Lagos", "I visited...", 2)
     * yields a request body of title=My+Visit+To+Lagos&body=I+visited...&userId=2.
     *
     */
}
