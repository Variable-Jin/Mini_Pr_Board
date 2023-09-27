package com.agile.demo.dao.impl;

import com.agile.demo.Entity.Comment;
import com.agile.demo.dao.CommentDAO;
import com.agile.demo.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static com.agile.demo.Entity.QComment.comment;

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

    }

    @Override
    public Comment selectComment(Long commentId) {
        Comment selectComment = commentRepository.getById(commentId);

        return selectComment;
    }

    public List<Comment> findByComment(Long commentId) {
        return queryFactory.selectFrom(comment)
                .leftJoin(comment.parent).fetchJoin()
                .where(comment.parent.commentId.eq(commentId))
                .orderBy(
                        comment.parent.commentId.asc().nullsFirst(),
                        comment.createdAT.asc()
                )
                .fetch();
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
