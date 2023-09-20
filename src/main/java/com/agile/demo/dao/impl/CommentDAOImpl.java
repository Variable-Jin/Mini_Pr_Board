package com.agile.demo.dao.impl;

import com.agile.demo.Entity.Board;
import com.agile.demo.Entity.Comment;
import com.agile.demo.dao.CommentDAO;
import com.agile.demo.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class CommentDAOImpl implements CommentDAO {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentDAOImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public Comment insertComment(Comment comment) {
        Comment savedComment = commentRepository.save(comment);

        return savedComment;
    }

    @Override
    public Comment selectComment(Long commentId) {
        Comment selectComment = commentRepository.getById(commentId);

        return selectComment;
    }

    @Override
    public Comment updateCommentContent(Long commentId, String commentWriter, String commentContents) throws Exception {
        Optional<Comment> selectComment = commentRepository.findById(commentId);

        Comment updateComment;
        if (selectComment.isPresent()) {
            Comment comment = selectComment.get();

            comment.getCommentWriter();
            comment.getCommentContents();
            comment.setUpdatedAT(LocalDateTime.now());

            updateComment = commentRepository.save(comment);
        } else {
            throw new Exception();
        }

        return updateComment;
    }

    @Override
    public void deleteComment(Long commentId) throws Exception {
        Optional<Comment> selectedComment = commentRepository.findById(commentId);

        if (selectedComment.isPresent()) {
            Comment comment = selectedComment.get();

            commentRepository.delete(comment);
        } else {
            throw new Exception();
        }
    }
}
