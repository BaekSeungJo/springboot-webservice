package com.devbaek.book.springboot.web.dto;

import com.devbaek.book.springboot.domain.posts.Posts;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * Project : springboot-webservice
 * Class: PostsListResponseDto
 * Created by baegseungjo on 2020-12-15
 * <p>
 * Description:
 */
@Getter
public class PostsListResponseDto {
    private Long id;
    private String title;
    private String author;
    private LocalDateTime modifiedDate;

    public PostsListResponseDto(Posts posts) {
        this.id = posts.getId();
        this.title = posts.getTitle();
        this.author = posts.getAuthor();
        this.modifiedDate = posts.getModifiedDate();
    }
}
