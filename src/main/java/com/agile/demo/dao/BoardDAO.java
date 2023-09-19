package com.agile.demo.dao;

import com.agile.demo.Entity.Board;

public interface BoardDAO {

    Board insertBoard(Board board);

    Board selectBoard(Long BoardIdx);
    Board updateBoardTitle(Long boardIdx, String title, String contents) throws Exception;

    void deleteBoard(Long BoardIdx) throws Exception;

}
