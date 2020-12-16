package com.devbaek.book.springboot.web.dto;

import com.devbaek.book.springboot.domain.posts.Posts;
import lombok.Getter;

/**
 * Project : springboot-webservice
 * Class: PostsResponseDto
 * Created by baegseungjo on 2020-12-07
 * <p>
 * Description:
 */
@Getter
public class PostsResponseDto {

    private Long id;
    private String title;
    private String content;
    private String author;

    public PostsResponseDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}
