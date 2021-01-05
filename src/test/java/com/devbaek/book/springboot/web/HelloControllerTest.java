package com.devbaek.book.springboot.web;

import com.devbaek.book.springboot.config.auth.SecurityConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Project : springboot-webservice
 * Class: HelloControllerTest
 * Created by baegseungjo on 2020-12-06
 * <p>
 * Description:
 *
 * test directory에 application.yml을 추가하여 Google OAuth2 관련 테스트 설정 값을 지정한다.
 * 해당 값으로 인해 OAuth 인증을 진행하기 때문에 @MockUser(role="USER")을 추가하여 사용자 권한을 가지고 있는 사용자가 호출한 것처럼 만든다.
 *
 * spring-boot-autoconfigure-2.4.0.jar -> META-INF -> spring.factories 에 보면
 * org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration 이 @EnableAutoConfiguration에 의해 자동으로 빈 등록된다.
 * SecurityAutoConfiguration -> WebSecurityEnablerConfiguration -> OAuth2ClientConfiguration 빈이 등록되기 때문에 @WithMockUser(role="USER")을 추가하여
 * 인증된 사용자 목을 구성해야 한다.
 *
 * @WebMvcTest는 slice 테스트로 Controler와 관련된 빈, Security 관련 빈만 스캔하기 때문에 SecurityConfig에서 사용하는 CustomOAuth2UserService는 @Service이기 때문에
 * 스캔 대상에서 빠져서 빈을 찾지 못한다.
 *
 * 따라서, @WebMvcTest의 excluseFilters에 SecurityConfig를 스캔에서 제외하여 문제를 해결한다.
 *
 *
 *
 * @WebMvcTest는 MockMvc도 auto configuration한다.
 *
 */
@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = HelloController.class,
excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = SecurityConfig.class)})
class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

    @WithMockUser(roles = "USER")
    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }

    @WithMockUser(roles = "USER")
    @Test
    public void helloDto가_리턴된다() throws Exception {
        // given
        String name = "hello";
        int amount = 1000;

        mvc.perform(get("/hello/dto").param("name", name).param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(name))
                .andExpect(jsonPath("$.amount").value(amount));
    }
}
