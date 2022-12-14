package com.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.entity.PostEntity;

public interface PostRepository extends JpaRepository<PostEntity, Integer> {

}
