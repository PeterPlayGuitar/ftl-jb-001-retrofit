package com.a_peter0.retrofit.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PostUpdateRequest {
    private Integer id;
    private Integer userId;
    private String title;
    private String body;
}
