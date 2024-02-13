package com.agile.demo.controller;

import com.agile.demo.dto.CommentDto;
import com.agile.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        CommentDto createdDto = commentService.create(BoardId, commentDto);
        return ResponseEntity.status(HttpStatus.OK).body(createdDto);
    }

    @PatchMapping("/api/boards/{BoardId}/comments")
    public ResponseEntity<CommentDto> update(@PathVariable Long BoardId, @RequestBody CommentDto commentDto) {
        CommentDto updatedDto = commentService.updated(BoardId, commentDto);
        return ResponseEntity.status(HttpStatus.OK).body(updatedDto);
    }

    @DeleteMapping("/api/boards/{BoardId}/comments")
    public ResponseEntity<CommentDto> delete(@PathVariable Long BoardId) {
        CommentDto deletedDto = commentService.delete(BoardId);
        return ResponseEntity.status(HttpStatus.OK).body(deletedDto);
    }

}





