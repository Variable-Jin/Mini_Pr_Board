package com.agile.demo.repository;

import com.agile.demo.Entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

}
