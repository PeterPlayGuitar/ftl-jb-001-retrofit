package com.a_peter0.retrofit.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PostResponse {
    private Integer userId;
    private Integer id;
    private String title;
    private String body;
}
