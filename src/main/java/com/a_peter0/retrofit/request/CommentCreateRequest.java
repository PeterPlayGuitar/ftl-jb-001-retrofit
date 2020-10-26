package com.a_peter0.retrofit.request;

import lombok.Builder;

@Builder
public class CommentCreateRequest {
    private Integer postId;
    private String name;
    private String email;
    private String body;
}
