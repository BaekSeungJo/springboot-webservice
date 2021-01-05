package com.devbaek.book.springboot.config.auth.dto;

import com.devbaek.book.springboot.domain.user.User;
import lombok.Getter;

import java.io.Serializable;

/**
 * Project : springboot-webservice
 * Class: SessionUser
 * Created by baegseungjo on 2020-12-21
 * <p>
 * Description:
 */
@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}
