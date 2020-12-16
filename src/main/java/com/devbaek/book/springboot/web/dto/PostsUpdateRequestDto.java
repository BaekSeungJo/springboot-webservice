package com.devbaek.book.springboot.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Project : springboot-webservice
 * Class: PostsUpdateRequestDto
 * Created by baegseungjo on 2020-12-07
 * <p>
 * Description:
 */
@Getter
@NoArgsConstructor
public class PostsUpdateRequestDto {
    private String title;
    private String content;

    @Builder
    public PostsUpdateRequestDto(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
