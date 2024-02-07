package com.agile.demo.service;

import com.agile.demo.Entity.Board;
import com.agile.demo.dto.BoardDto;
import com.agile.demo.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    public List<Board> findAll() {
        return boardRepository.findAll();
    }

    public Board findById(Long boardIdx) {
        return boardRepository.findById(boardIdx).orElse(null);
    }

    public Board create(BoardDto boardDto) {
        Board board = boardDto.toEntity();
        if (board.getBoardIdx() != null) {
            return null;
        }
        return boardRepository.save(board);
    }

    public Board update(Long boardIdx, BoardDto boardDto) {
        Board board = boardRepository.findById(boardIdx)
                .orElseThrow(() -> new IllegalArgumentException("게시판을 업데이트 할 수 없습니다. 대상 id가 없습니다"));

        board.setTitle(boardDto.getTitle());
        board.setContents(boardDto.getContents());

        return boardRepository.save(board);
    }

    public Board delete(Long boardIdx) {
        Board deleted = boardRepository.findById(boardIdx).orElse(null);

        if (deleted != null) {
            boardRepository.delete(deleted);
        }

        return deleted;
    }

}


