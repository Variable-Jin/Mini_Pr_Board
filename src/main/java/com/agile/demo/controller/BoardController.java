package com.agile.demo.controller;

import com.agile.demo.Entity.Board;
import com.agile.demo.dto.BoardDto;
import com.agile.demo.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BoardController {

    @Autowired
    private BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    // 전체 게시글 조회
    @GetMapping("/api/boards")
    public List<Board> getAllBoard() {
        return boardService.findAll();
    }

    // 특정 게시판 조회
    @GetMapping("/api/boards/{BoardId}")
    public ResponseEntity<Board> getBoard(@PathVariable Long BoardId) {
        Board board = boardService.findById(BoardId);

        if (board != null) {
            return ResponseEntity.ok(board);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 게시판 생성
    @PostMapping("/api/boards")
    public ResponseEntity<Board> createBoard(@RequestBody BoardDto boardDto) {
        Board created = boardService.create(boardDto);

        if (created != null ) {
            return ResponseEntity.status(HttpStatus.CREATED).body(created);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


    // 게시판 업데이트
    @PatchMapping("/api/boards/{BoardId}")
    public ResponseEntity<Board> updateBoard(@PathVariable Long BoardIdx, @RequestBody BoardDto boardDto) {
        Board updated = boardService.update(BoardIdx, boardDto);

        if (updated != null) {
            return ResponseEntity.status(HttpStatus.OK).body(updated);
        } else  {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


    // 게시판 삭제
    @DeleteMapping("/api/boards/{BoardId}")
    public ResponseEntity<Board> deletedBoard(@PathVariable Long BoardId) {
        Board deleted = boardService.delete(BoardId);

        if (deleted != null ) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}


