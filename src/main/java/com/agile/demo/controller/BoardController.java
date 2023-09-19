package com.agile.demo.controller;

import com.agile.demo.dto.BoardDto;
import com.agile.demo.dto.BoardResponseDto;

import com.agile.demo.dto.ChangeBoardTitleDto;
import com.agile.demo.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;

    }

    @GetMapping("/{BoardIdx}")
    public ResponseEntity<BoardResponseDto> getBoard(@PathVariable Long BoardIdx) {
        BoardResponseDto boardResponseDto = boardService.getBoard(BoardIdx);

        return ResponseEntity.status(HttpStatus.OK).body(boardResponseDto);
    }

    @PostMapping()
    public ResponseEntity<BoardResponseDto> createBoard(@RequestBody BoardDto boardDto) {

        BoardResponseDto boardResponseDto = boardService.saveBoard(boardDto);


        return ResponseEntity.status(HttpStatus.OK).body(boardResponseDto);

    }

    @PutMapping("/{BoardIdx}")
    public ResponseEntity<BoardResponseDto> changeBoardTitle(
            @PathVariable Long BoardIdx,
            @RequestBody ChangeBoardTitleDto changeBoardTitleDto) throws Exception {
        BoardResponseDto boardResponseDto = boardService.changeBoardTitle(
                BoardIdx,
                changeBoardTitleDto.getTitle(),
                changeBoardTitleDto.getContents());

        return ResponseEntity.status(HttpStatus.OK).body(boardResponseDto);
    }

    @DeleteMapping("/{BoardIdx}")
    public ResponseEntity<String> deleteBoard(@PathVariable Long BoardIdx) throws Exception {
        boardService.deleteBoard(BoardIdx);

        return ResponseEntity.status(HttpStatus.OK).body("삭제가 왼료되었습니다.");

    }

}
