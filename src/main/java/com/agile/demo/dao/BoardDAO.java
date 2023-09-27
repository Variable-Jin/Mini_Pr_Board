package com.agile.demo.dao;

import com.agile.demo.Entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardDAO {

    Page<Board> findAll(Pageable pageable);
    Board insertBoard(Board board);

    Board selectBoard(Long BoardIdx);
    Board updateBoardTitle(Long boardIdx, String title, String contents) throws Exception;

    void deleteBoard(Long BoardIdx) throws Exception;

}
