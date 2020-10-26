package com.a_peter0.retrofit.request;

import lombok.Builder;

@Builder
public class AlbumUpdateRequest {
    private Integer id;
    private Integer userId;
    private String title;
}
