package com.devbaek.book.springboot.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Project : springboot-webservice
 * Class: Role
 * Created by baegseungjo on 2020-12-17
 * <p>
 * Description:
 */
@Getter
@RequiredArgsConstructor
public enum Role {

    GUEST("ROLE_GUEST", "손님"),
    USER("ROLE_USER", "일반 사용자");
    
    private final String key;
    private final String title;
}
