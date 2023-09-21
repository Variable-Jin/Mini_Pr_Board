package com.agile.demo.controller;


import com.agile.demo.dto.*;
import com.agile.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;

    }

    @GetMapping("/{commentId}")
    public ResponseEntity<CommentResponseDto> getComment(@PathVariable Long commentId) {
        CommentResponseDto commentResponseDto = commentService.getComment(commentId);

        return ResponseEntity.status(HttpStatus.OK).body(commentResponseDto);
    }

    @PostMapping()
    public ResponseEntity<CommentResponseDto> createComment(@RequestBody CommentDto commentDto) {

        CommentResponseDto commentResponseDto = commentService.saveComment(commentDto);

        return ResponseEntity.status(HttpStatus.OK).body(commentResponseDto);

    }

    @PutMapping("/{commentId}")
    public ResponseEntity<CommentResponseDto> changeCommentContent(
            @PathVariable Long commentId,
            @RequestBody ChangeCommentContentDto changeCommentContentDto) throws Exception {
        CommentResponseDto commentResponseDto = commentService.changeCommentContent(
                commentId,
                changeCommentContentDto.getCommentContents());

        return ResponseEntity.status(HttpStatus.OK).body(commentResponseDto);
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<String> deleteComment(Long commentId) throws Exception {
        commentService.deleteComment(commentId);

        return ResponseEntity.status(HttpStatus.OK).body("삭제가 완료되었습니다.");
    }

}
