package com.agile.demo.dao;

import com.agile.demo.Entity.Comment;

public interface CommentDAO {

    Comment insertComment(Comment comment);

    Comment selectComment(Long commentId);

    Comment updateCommentContent(Long commentId, String commentWriter, String commentContents) throws Exception;

    void deleteComment(Long commentId) throws Exception;

}
