package com.devbaek.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Project : springboot-webservice
 * Class: PostRepository
 * Created by baegseungjo on 2020-12-07
 * <p>
 * Description:
 */
@Repository
public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query("SELECT p FROM Posts p ORDER BY p.id desc")
    List<Posts> findAllDesc();
}
