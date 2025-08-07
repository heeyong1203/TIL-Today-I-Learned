package com.sinse.restapp.model.board;

import com.sinse.restapp.domain.Board;

import java.util.List;

public interface BoardService {
    public List<Board> selectAll();
    public Board select(int board_id);
    public void create(Board board);
    public Board update(Board board);
    public void delete(int board_id);
}
