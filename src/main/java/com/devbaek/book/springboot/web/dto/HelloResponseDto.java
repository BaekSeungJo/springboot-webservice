package com.devbaek.book.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Project : springboot-webservice
 * Class: HelloResponseDto
 * Created by baegseungjo on 2020-12-07
 * <p>
 * Description:
 */
@Getter
@RequiredArgsConstructor
public class HelloResponseDto {

    private final String name;
    private final int amount;
}
