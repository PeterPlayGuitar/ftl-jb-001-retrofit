package com.a_peter0.retrofit.request;

import lombok.Builder;

@Builder
public class AlbumCreateRequest {
    private Integer userId;
    private String title;
}
