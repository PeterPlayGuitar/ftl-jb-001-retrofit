package com.a_peter0.retrofit;

import com.a_peter0.retrofit.request.*;
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

    @GET("/users/{id}/albums")
    Call<List<AlbumResponse>> getUsersAlbumsById(@Path("id") Integer id);

    @GET("/albums")
    Call<List<AlbumResponse>> getAlbums();

    @GET("/albums/{id}")
    Call<AlbumResponse> getAlbumsById(@Path("id") Integer id);

    @POST("/albums")
    Call<AlbumResponse> createAlbum(@Body AlbumCreateRequest request);

    @PUT("/albums/{id}")
    Call<AlbumResponse> updateAlbum(@Path("id") Integer id, @Body AlbumUpdateRequest request);

    @DELETE("/albums/{id}")
    Call<Void> deleteAlbum(@Path("id") Integer id);

    @GET("/users")
    Call<List<UserResponse>> getUsers();

    @GET("/users/{id}")
    Call<UserResponse> getUserById(@Path("id") Integer id);

    @POST("/users")
    Call<UserResponse> createUser(@Body UserCreateRequest request);

    @PUT("/users/{id}")
    Call<UserResponse> updateUser(@Path("id") Integer id, @Body UserUpdateRequest request);

    @DELETE("/users/{id}")
    Call<Void> deleteUser(@Path("id") Integer id);
}
