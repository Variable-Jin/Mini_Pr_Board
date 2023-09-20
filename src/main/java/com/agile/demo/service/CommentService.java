package com.agile.demo.service;

import com.agile.demo.dto.CommentResponseDto;

public interface CommentService {

    CommentResponseDto getComment(Long commentId);
    CommentResponseDto saveComment
}
