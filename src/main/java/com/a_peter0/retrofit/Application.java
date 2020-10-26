package com.a_peter0.retrofit;

import com.a_peter0.retrofit.request.*;
import lombok.val;

import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException {
        System.out.println("Start");
        JsonPlaceholderApi api = JsonPlaceholderService.getInstance().getJSONApi();

        System.out.println("------------ GET COMMENTS ------------");
        val comments = api.getComments().execute().body();
        System.out.println(comments);
        System.out.println();

        System.out.println("------------ GET COMMENT BY ID ------------");
        val commentById = api.getCommentById(2).execute().body(); 
        System.out.println(commentById);
        System.out.println();

        System.out.println("------------ CREATE COMMENT ------------");
        val createdComment = api.createComment(
                CommentCreateRequest.builder()
                        .body("Вау круто!")
                        .email("peepeepoopoo@gmail.com")
                        .name("Peter")
                        .postId(4)
                        .build()
        ).execute().body();
        System.out.println(createdComment);
        System.out.println();

        System.out.println("------------ UPDATE COMMENT ------------");
        val updatedComment = api.updateComment(2,
                CommentUpdateRequest.builder()
                        .body("хватит лайкать)")
                        .email("1123peepeepoopoo@gmail.com")
                        .name("PeterWow")
                        .postId(3)
                        .build()
        ).execute().body();
        System.out.println(updatedComment);
        System.out.println();

        System.out.println("------------ DELETE COMMENT ------------");
        val isSuccessful = api.deleteComment(2).execute().isSuccessful();
        System.out.println(isSuccessful);
        System.out.println();
        System.out.println();


        System.out.println("-----------------------------------------------------------");
        System.out.println("------------ TASK 004 -------------------------------------");
        System.out.println("-----------------------------------------------------------");
        System.out.println();

        System.out.println("------------ GET POST'S COMMENTS ------------");
        val postsComments = api.getPostComments(2).execute().body();
        System.out.println(postsComments);

        System.out.println("------------ GET PHOTOS FROM ALBUM ------------");
        val pics = api.getAlbumPhotos(2).execute().body();
        System.out.println(pics);

        System.out.println("------------ GET ALBUMS OF USER ------------");
        val albums = api.getUsersAlbumsById(2).execute().body();
        System.out.println(albums);

        System.out.println("------------ GET TODOS OF USER ------------");
        val todos = api.getUsersTodosById(2).execute().body();
        System.out.println(todos);

        System.out.println("------------ GET POSTS OF USER ------------");
        val posts = api.getUsersPostsById(2).execute().body();
        System.out.println(posts);

       /*
        System.out.println("------------ GET USERS ------------");
        val users = api.getUsers().execute().body();
        System.out.println(users);
        System.out.println();

        System.out.println("------------ GET USER BY ID ------------");
        val userById = api.getUserById(2).execute().body();
        System.out.println(userById);
        System.out.println();

        System.out.println("------------ CREATE USER ------------");
        UserResponse createdUser = api.createUser(
                UserCreateRequest.builder()
                        .email("peepeepoopoo@yande.ru")
                        .name("Peter")
                        .username("Zelinskiy")
                        .address(new UserCreateRequest.Address("Pushkina", "Volga", "Volgograd", "103843",
                                new UserCreateRequest.Geo("24356349", "397429")))
                        .company(new UserCreateRequest.Company("PeepeePoopoo", "We can do it", "bs001"))
                        .phone("+783473984723")
                        .website("peepeepoopoo.ru")
                        .build()
        ).execute().body();
        System.out.println(createdUser);
        System.out.println();

        System.out.println("------------ UPDATE USER ------------");
        val updatedUser = api.updateUser(1,
                UserUpdateRequest.builder()
                        .email("1111WOWnice@yande.ru")
                        .name("Vasya")
                        .username("DZelinskiy")
                        .address(new UserUpdateRequest.Address("111Pushkina", "11Volga", "11Volgograd", "6666666",
                                new UserUpdateRequest.Geo("24356349", "397429")))
                        .company(new UserUpdateRequest.Company("WOWnice", "We can do it, maybe", "sb111"))
                        .phone("+1234566788")
                        .website("WOWnice.ru")
                        .build()
        ).execute().body();
        System.out.println(updatedUser);
        System.out.println();

        System.out.println("------------ DELETE USER ------------");
        val isSuccessful = api.deleteUser(2).execute().isSuccessful();
        System.out.println(isSuccessful);
        System.out.println();
        */

        /*
        System.out.println("------------ GET ALBUMS ------------");
        val albums = api.getAlbums().execute().body();
        System.out.println(albums);
        System.out.println();

        System.out.println("------------ GET ALBUMS BY ID ------------");
        val albumById = api.getAlbumsById(2).execute().body();
        System.out.println(albumById);
        System.out.println();

        System.out.println("------------ CREATE ALBUM ------------");
        val createdAlbum = api.createAlbum(
                AlbumCreateRequest.builder()
                        .title("Summer")
                        .userId(5)
                        .build()).execute().body();
        System.out.println(createdAlbum);
        System.out.println();

        System.out.println("------------ UPDATE ALBUM ------------");
        val updatedAlbum = api.updateAlbum(1,
                AlbumUpdateRequest.builder()
                        .title("Summer")
                        .id(3000)
                        .userId(5)
                        .build()).execute().body();
        System.out.println(updatedAlbum);
        System.out.println();

        System.out.println("------------ DELETE ALBUM ------------");
        val isSuccessful = api.deleteAlbum(2).execute().isSuccessful();
        System.out.println(isSuccessful);
        System.out.println();
        */

       /* System.out.println("------------ POSTS ------------");
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
        val albums = api.getAlbumsById(2).execute().body();
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
        });*/
    }
}
