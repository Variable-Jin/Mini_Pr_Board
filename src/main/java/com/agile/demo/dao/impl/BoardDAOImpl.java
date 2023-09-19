package com.agile.demo.dao.impl;

import com.agile.demo.Entity.Board;
import com.agile.demo.dao.BoardDAO;
import com.agile.demo.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class BoardDAOImpl implements BoardDAO {

    private final BoardRepository boardRepository;

    @Autowired
    public BoardDAOImpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    public Board insertBoard(Board board) {
        Board savedBoard = boardRepository.save(board);

        return savedBoard;
    }

    @Override
    public Board selectBoard(Long BoardIdx) {
        Board selectBoard = boardRepository.getById(BoardIdx);

        return selectBoard;
    }

    @Override
    public Board updateBoardTitle(Long BoardIdx, String title, String contents) throws Exception {
        Optional<Board> selectBoard = boardRepository.findById(BoardIdx);

        Board updateBoard;
        if (selectBoard.isPresent()) {
            Board board = selectBoard.get();

            board.setTitle(title);
            board.setContents(contents);
            board.setUpdatedAT(LocalDateTime.now());

            updateBoard = boardRepository.save(board);
        } else {
            throw new Exception();
        }

        return updateBoard;
    }

    @Override
    public void deleteBoard(Long BoardIdx) throws Exception {
        Optional<Board> selectedBoard = boardRepository.findById(BoardIdx);

        if (selectedBoard.isPresent()) {
            Board board = selectedBoard.get();

            boardRepository.delete(board);
        } else {
            throw new Exception();
        }
    }
}

