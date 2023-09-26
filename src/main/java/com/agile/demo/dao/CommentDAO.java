package com.agile.demo.dao;

import com.agile.demo.Entity.Comment;

import java.util.List;

public interface CommentDAO {

    Comment insertComment(Comment comment, Long parentId);

    Comment selectComment(Long commentId);

    Comment updateCommentContent(Long commentId, String commentContents) throws Exception;

    void deleteComment(Long commentId) throws Exception;


}
