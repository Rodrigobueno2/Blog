package com.spring.codeblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.codeblog.model.Post;

public interface CodeblogRepository extends JpaRepository<Post, Long> {

}
