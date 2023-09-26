package com.agile.demo.service.impl;

import com.agile.demo.Entity.Comment;
import com.agile.demo.dao.CommentDAO;
import com.agile.demo.dto.CommentDto;
import com.agile.demo.dto.CommentResponseDto;
import com.agile.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.PublicKey;
import java.time.LocalDateTime;


@Service
public class CommentServiceImpl implements CommentService {

    private final CommentDAO commentDAO;

    @Autowired
    public CommentServiceImpl(CommentDAO commentDAO) {
        this.commentDAO = commentDAO;
    }

    @Override
    public CommentResponseDto getComment(Long commentId) {
        Comment comment = commentDAO.selectComment(commentId);

        CommentResponseDto commentResponseDto = new CommentResponseDto();
        commentResponseDto.setCommentId(comment.getCommentId());
        commentResponseDto.setCommentWriter(comment.getCommentWriter());
        commentResponseDto.setCommentContents(comment.getCommentContents());

        return commentResponseDto;

    }


    @Override
    public CommentResponseDto saveComment(CommentDto commentDto, Long parentId) {
        Comment comment = new Comment();
        comment.setCommentWriter(comment.getCommentWriter());
        comment.setCommentContents(comment.getCommentContents());
        comment.setCreatedAT(LocalDateTime.now());
        comment.setUpdatedAT(LocalDateTime.now());

        Comment savedComment = commentDAO.insertComment(comment, parentId);

        CommentResponseDto commentResponseDto = new CommentResponseDto();
        commentResponseDto.setCommentId(savedComment.getCommentId());
        commentResponseDto.setCommentWriter(savedComment.getCommentWriter());
        commentResponseDto.setCommentContents(savedComment.getCommentContents());

        return commentResponseDto;

    }

    @Override
    public CommentResponseDto changeCommentContent(Long commentId, String commentContents) throws Exception {
        CommentResponseDto commentResponseDto = new CommentResponseDto();
        commentResponseDto.setCommentId(commentResponseDto.getCommentId());
        commentResponseDto.setCommentWriter(commentResponseDto.getCommentWriter());
        commentResponseDto.setCommentContents(commentResponseDto.getCommentContents());

        return commentResponseDto;
    }

    @Override
    public void deleteComment(Long commentId) throws Exception {
        commentDAO.deleteComment(commentId);

    }

}
