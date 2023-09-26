package com.agile.demo.dao.impl;

import com.agile.demo.Entity.Comment;
import com.agile.demo.dao.CommentDAO;
import com.agile.demo.repository.CommentRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CommentDAOImpl implements CommentDAO {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentDAOImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public Comment insertComment(Comment comment, Long parentId) {
        // 대댓글 관련
        Comment parentComment = commentRepository.findById(parentId).orElse(null);

        if (parentComment == null) {
            throw new EntityNotFoundException("Not found comment id");
        }

        comment.setParent(parentComment);

        Comment savedComment = commentRepository.save(comment);

        return savedComment;
ds
    }

//    @Override
    public Comment selectComment(Long commentId) {
        Comment selectComment = commentRepository.getById(commentId);
//
//        comment.setchildren(queryFactory.selectFrom(QComment.comment)
//                .where(QComment.comment.parentComment.id.eq(commentId))
//                .fatch());

        return selectComment;
    }

    @Override
    public Comment updateCommentContent(Long commentId, String commentContents) throws Exception {
        Optional<Comment> selectComment = commentRepository.findById(commentId);

        Comment updateComment;
        if (selectComment.isPresent()) {
            Comment comment = selectComment.get();

            comment.setCommentContents(commentContents);
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
