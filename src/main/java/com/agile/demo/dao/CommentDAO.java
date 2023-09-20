package com.agile.demo.dao;

import com.agile.demo.Entity.Comment;

public interface CommentDAO {

    Comment insertComment(Comment comment);

    Comment selectComment(Comment comment);

    Comment selectComment(Long commentId);

    Comment updateCommentContent(Long commentId, String commentWriter, String commentContents) throws Exception;

    Comment deleteComment(Long commentId) throws Exception;

}
