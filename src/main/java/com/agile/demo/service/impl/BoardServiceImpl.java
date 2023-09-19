package com.agile.demo.service.impl;

import com.agile.demo.Entity.Board;
import com.agile.demo.dao.BoardDAO;
import com.agile.demo.dto.BoardDto;
import com.agile.demo.dto.BoardResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.agile.demo.service.BoardService;

import java.time.LocalDateTime;

@Service
public class BoardServiceImpl implements BoardService {

    private final BoardDAO boardDAO;

    @Autowired
    public BoardServiceImpl(BoardDAO boardDAO) {
        this.boardDAO = boardDAO;
    }

    @Override
    public BoardResponseDto getBoard(Long BoardIdx) {
        Board board = boardDAO.selectBoard(BoardIdx);

        BoardResponseDto boardResponseDto = new BoardResponseDto();
        boardResponseDto.setBoardIdx(board.getBoardIdx());
        boardResponseDto.setTitle(board.getTitle());
        boardResponseDto.setContents(board.getContents());

        return boardResponseDto;
    }

    @Override
    public BoardResponseDto saveBoard(BoardDto boardDto) {
        Board board = new Board();
        board.setTitle(boardDto.getTitle());
        board.setContents(boardDto.getContents());
        board.setCreatedAT(LocalDateTime.now());
        board.setUpdatedAT(LocalDateTime.now());

        Board savedBoard = boardDAO.insertBoard(board);

        BoardResponseDto boardResponseDto = new BoardResponseDto();
        boardResponseDto.setBoardIdx(savedBoard.getBoardIdx());
        boardResponseDto.setTitle(savedBoard.getTitle());
        boardResponseDto.setContents(savedBoard.getContents());

        return boardResponseDto;
    }

    @Override
    public BoardResponseDto changeBoardTitle(Long BoardIdx, String title, String contents) throws Exception {
        Board changedBoard = boardDAO.updateBoardTitle(BoardIdx, title, contents);

        BoardResponseDto boardResponseDto = new BoardResponseDto();
        boardResponseDto.setBoardIdx(changedBoard.getBoardIdx());
        boardResponseDto.setTitle(changedBoard.getTitle());
        boardResponseDto.setContents(changedBoard.getContents());

        return boardResponseDto;
    }

    @Override
    public void deleteBoard(Long BoardIdx) throws Exception {
        boardDAO.deleteBoard(BoardIdx);

    }
}
