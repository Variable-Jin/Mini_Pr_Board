package com.agile.demo.service;

import com.agile.demo.Entity.Comment;
import com.agile.demo.dto.CommentDto;
import com.agile.demo.dto.CommentResponseDto;

public interface CommentService {

    CommentResponseDto getComment(Long commentId);

    CommentResponseDto saveComment(CommentDto commentDto, Long parnetId);

    CommentResponseDto changeCommentContent(Long commentId, String commentContents) throws Exception;

    void deleteComment(Long commentId) throws Exception;

}
