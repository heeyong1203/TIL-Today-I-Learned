package com.sinse.restapp.controller;

import com.sinse.restapp.domain.Board;
import com.sinse.restapp.model.board.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
public class BoardController {

    private BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/test")
    public String test() {
        return "Heeyong";
    }

    //게시판 목록 요청 처리
    @GetMapping("/boards")
    public List<String> selectAll(){
        log.debug("목록 요청 받음");
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("orange");
        list.add("grape");
        return list;
    }

    //글쓰기 요청 처리
    @PostMapping("/boards")
    //json 문자열로 전송된 파라미터와 서버 측의 모델과의 자동 매핑 (주의 : 고전적 스프링에도 지원되었음)
    public ResponseEntity<String> regist(@RequestBody Board board) {
        boardService.create(board);
        log.debug("insert 실행");
        return ResponseEntity.ok("success");
    }

    //글목록 조회 요청 처리
    @GetMapping("/boards/{board_id}") //해당 url에 대해 RESTful 함을 이해하고 있다.
    public Board findOne(@PathVariable int board_id) {
        log.debug("select 실행");
        return boardService.select(board_id);
    }

    //글 수정 요청 처리
    @PutMapping("/boards/{board_id}")
    public ResponseEntity<String> update(@RequestBody Board board, @PathVariable int board_id) {
        board.setBoard_id(board_id);
        Board updatedBoard = boardService.update(board);
        return ResponseEntity.ok("success");
    }

    //글 삭제 요청 처리
    @DeleteMapping("/boards/{board_id}")
    public ResponseEntity<String> delete(@PathVariable int board_id) {
        boardService.delete(board_id);
        return ResponseEntity.ok("success");
    }
}
