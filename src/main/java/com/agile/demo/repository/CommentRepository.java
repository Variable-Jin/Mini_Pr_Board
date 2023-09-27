package com.agile.demo.repository;

import com.agile.demo.Entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByComment(Long commentId);


}
