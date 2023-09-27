package com.agile.demo.service;

import com.agile.demo.Entity.Board;
import com.agile.demo.dto.BoardDto;
import com.agile.demo.dto.BoardResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardService {

    static Page<Board> findAll(Pageable pageable);

    BoardResponseDto getBoard(Long BoardIdx);

    BoardResponseDto saveBoard(BoardDto boardDto);

    BoardResponseDto changeBoardTitle(Long BoardIdx, String title, String contents) throws Exception;

    void deleteBoard(Long BoardIdx) throws Exception;

}
