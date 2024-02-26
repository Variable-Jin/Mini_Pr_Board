package com.agile.demo.controller;

import com.agile.demo.dto.CommentDto;
import com.agile.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/api/boards/{BoardId}/comments")
    public ResponseEntity<List<CommentDto>> comments(@PathVariable Long BoardId) {
        List<CommentDto> commentDtos = commentService.comments(BoardId);
        return ResponseEntity.status(HttpStatus.OK).body(commentDtos);
    }

    @PostMapping("/api/boards/{BoardId}/comments")
    public ResponseEntity<CommentDto> create(@PathVariable Long BoardId, @RequestBody CommentDto commentDto) {
        LocalDateTime now = LocalDateTime.now();
        commentDto.setCreatedAT(now);
        commentDto.setUpdatedAT(now);
        CommentDto createdDto = commentService.create(BoardId, commentDto);
        return ResponseEntity.status(HttpStatus.OK).body(createdDto);
    }

//    // 대댓글
    @PostMapping("/api/boards/{BoardId}/comments/{parentId}/replies")
    public ResponseEntity<CommentDto> createReply(@PathVariable Long BoardId, @PathVariable Long parentId, @RequestBody CommentDto commentDto) {
        LocalDateTime now = LocalDateTime.now();
        commentDto.setCreatedAT(now);
        commentDto.setUpdatedAT(now);
        CommentDto createdReplyDto = commentService.createReply(BoardId, parentId, commentDto);
        return ResponseEntity.status(HttpStatus.OK).body(createdReplyDto);
    }


    @PatchMapping("/api/boards/{BoardId}/comments")
    public ResponseEntity<CommentDto> update(@PathVariable Long BoardId, @RequestBody CommentDto commentDto) {
        LocalDateTime now = LocalDateTime.now();
        commentDto.setUpdatedAT(now);
        CommentDto updatedDto = commentService.updated(BoardId, commentDto);
        return ResponseEntity.status(HttpStatus.OK).body(updatedDto);
    }

    @DeleteMapping("/api/boards/{BoardId}/comments")
    public ResponseEntity<CommentDto> delete(@PathVariable Long BoardId) {
        CommentDto deletedDto = commentService.delete(BoardId);
        return ResponseEntity.status(HttpStatus.OK).body(deletedDto);
    }

}





