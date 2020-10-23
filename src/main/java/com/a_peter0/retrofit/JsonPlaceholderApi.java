package com.a_peter0.retrofit;

import com.a_peter0.retrofit.request.PostCreateRequest;
import com.a_peter0.retrofit.request.PostUpdateRequest;
import com.a_peter0.retrofit.response.AlbumResponse;
import com.a_peter0.retrofit.response.CommentResponse;
import com.a_peter0.retrofit.response.PostResponse;
import com.a_peter0.retrofit.response.UserResponse;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface JsonPlaceholderApi {

    @GET("/posts")
    Call<List<PostResponse>> postsGet(@Query("userId") Integer userId);

    @POST("/posts")
    Call<PostResponse> postsCreate(@Body PostCreateRequest request);

    @PUT("/posts/{id}")
    Call<PostResponse> postsUpdate(@Path("id") Integer id, @Body PostUpdateRequest request);

    @DELETE("/posts/{id}")
    Call<Void> postsDelete(@Path("id") Integer id);

    @GET("/posts/{id}")
    Call<PostResponse> postsGetById(@Path("id") Integer id);

    @GET("/posts/{id}/comments")
    Call<List<CommentResponse>> postComments(@Path("id") Integer id);

    @GET("/users")
    Call<List<UserResponse>> users();

    @GET("/users/{id}/albums")
    Call<List<AlbumResponse>> albums(@Path("id") Integer id);
}
