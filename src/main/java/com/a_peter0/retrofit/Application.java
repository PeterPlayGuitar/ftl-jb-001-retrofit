package com.a_peter0.retrofit;

import com.a_peter0.retrofit.request.PostCreateRequest;
import com.a_peter0.retrofit.request.PostUpdateRequest;
import com.a_peter0.retrofit.response.CommentResponse;
import lombok.val;
import lombok.var;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

public class Application {

    public static void main(String[] args) throws IOException {
        System.out.println("Start");
        JsonPlaceholderApi api = JsonPlaceholderService.getInstance().getJSONApi();

        System.out.println("------------ POSTS ------------");
        val posts = api.postsGet(10).execute().body();
        System.out.println(posts);

        System.out.println("------------ POSTS CREATE ------------");
        val postCreate = api.postsCreate(PostCreateRequest.builder()
                .userId(3)
                .title("New Post")
                .body("News")
                .build()).execute().body();
        System.out.println(postCreate);

        System.out.println("------------ POSTS UPDATE ------------");
        val postUpdate = api.postsUpdate(100, PostUpdateRequest.builder()
                .id(101)
                .userId(3)
                .title("New Post")
                .body("News")
                .build()).execute().body();
        System.out.println(postUpdate);

        System.out.println("------------ POST DELETE ------------");
        Boolean postDelete = api.postsDelete(1).execute().isSuccessful();
        System.out.println(postDelete);

        System.out.println("------------ POST GET BY ID ------------");
        val postGetById = api.postsGetById(3).execute().body();
        System.out.println(postGetById);

        System.out.println("------------ POST COMMENTS ------------");
        val comments = api.postComments(3).execute().body();
        System.out.println(comments);

        System.out.println("------------ USERS ------------");
        val users = api.users().execute().body();
        for (var user : users)
            System.out.println(user.getAddress().getCity());

        System.out.println("------------ ALBUMS ------------");
        val albums = api.albums(2).execute().body();
        System.out.println(albums);

        Call<List<CommentResponse>> commentsCall = api.postComments(1);
        Response<List<CommentResponse>> commentCallResponse = commentsCall.execute();
        if (commentCallResponse.isSuccessful() && commentCallResponse.code() == 22) {
            val responses = commentCallResponse.body();
        } else {
            if (commentCallResponse.code() == 400) {
                String error = commentCallResponse.errorBody().string();
            } else if (commentCallResponse.code() == 500) {
                String error = commentCallResponse.errorBody().string();
            } else if (commentCallResponse.code() == 403) {
                String error = commentCallResponse.errorBody().string();
            }
        }

        api.postComments(1).enqueue(new Callback<List<CommentResponse>>() {
            @Override
            public void onResponse(Call<List<CommentResponse>> call, Response<List<CommentResponse>> response) {
                List<CommentResponse> commentAsync = response.body();
            }

            @Override
            public void onFailure(Call<List<CommentResponse>> call, Throwable throwable) {
                throwable.printStackTrace();
            }
        });
    }
}
