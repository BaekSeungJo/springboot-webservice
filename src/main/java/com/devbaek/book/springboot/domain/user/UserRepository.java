package com.devbaek.book.springboot.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Project : springboot-webservice
 * Class: UserRepository
 * Created by baegseungjo on 2020-12-17
 * <p>
 * Description:
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
