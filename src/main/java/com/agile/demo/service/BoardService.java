package com.agile.demo.service;

import com.agile.demo.dto.BoardDto;
import com.agile.demo.dto.BoardResponseDto;

public interface BoardService {

    BoardResponseDto getBoard(Long BoardIdx);

    BoardResponseDto saveBoard(BoardDto boardDto);

    BoardResponseDto changeBoardTitle(Long BoardIdx, String title, String contents) throws Exception;

    void deleteBoard(Long BoardIdx) throws Exception;

}
