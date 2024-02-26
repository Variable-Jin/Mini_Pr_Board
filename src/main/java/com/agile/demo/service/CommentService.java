package com.agile.demo.service;

import com.agile.demo.Entity.Board;
import com.agile.demo.Entity.Comment;
import com.agile.demo.dto.CommentDto;
import com.agile.demo.repository.BoardRepository;
import com.agile.demo.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private BoardRepository boardRepository;


    public List<CommentDto> comments(Long boardId) {
        return commentRepository.findByBoardId(boardId)
                .stream()
                .map(comment -> CommentDto.createCommentDto(comment))
                .collect(Collectors.toList());
    }

    @Transactional
    public CommentDto create(Long boardId, CommentDto commentDto) {
//        LocalDateTime updatedAT = createdAT;
        Board board = boardRepository.findById(boardId)
                .orElseThrow(()-> new IllegalArgumentException("댓글 생성을 실패했습니다" + "대상 게시글이 없습니다."));
        Comment comment = Comment.createComment(commentDto, board);
        Comment created = commentRepository.save(comment);
        return CommentDto.createCommentDto(created);
    }


    public CommentDto createReply(Long boardId, Long parentId, CommentDto commentDto) {
        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new IllegalArgumentException("대댓글 생성을 실패했습니다" + "대상 댓글이 없습니다"));

        // 부모 댓글 검색
        List<Comment> parentComments = commentRepository.findByParentId(parentId);
        Comment parentComment = parentComments.stream()
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("대댓글 생성을 실패했습니다. 부모 댓글이 없습니다"));

        Comment reply = Comment.createReply(commentDto, board, parentComment);
        Comment createdReply = commentRepository.save(reply);
        return CommentDto.createReplyCommentDto(createdReply);
    }

    @Transactional
    public CommentDto updated(Long id, CommentDto commentDto) {
        Comment target = commentRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("댓글 수정을 실패했습니다" + "대상 댓글이 없습니다."));
        LocalDateTime now = LocalDateTime.now();
        commentDto.setUpdatedAT(now);
        target.patch(commentDto);
        Comment updated = commentRepository.save(target);
        return CommentDto.createCommentDto(updated);
    }


    public CommentDto delete(Long id) {
        Comment target = commentRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("댓글 삭제 실패했습니다" + "댓글 대상이 업습니다."));
        commentRepository.delete(target);
        return CommentDto.createCommentDto(target);
    }

}
