package com.sinse.restapp.model.board;

import com.sinse.restapp.domain.Board;
import com.sinse.restapp.exception.BoardException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
//JPA나 Hibernate에서는 DAO에서 db작업하는 것이 아닌 객체를 대상으로 CRUD를 처리하므로,
//exception은 service에서 처리한다.
public class BoardServiceImpl implements BoardService {

    //근래의 Spring에서는 @Autowired가 지양 대상이므로
    // 생성자를 통해 정확히 어떤 자료형을 사용할 지 명시하는 것이 좋다.
    private final BoardDAO boardDAO;

    public BoardServiceImpl(@Qualifier("mybatisBoardDAO") BoardDAO boardDAO) {
        this.boardDAO = boardDAO;
    }

    @Override
    public List<Board> selectAll() throws DataAccessException {
        try {
            return boardDAO.selectAll();
        } catch (DataAccessException e) {
            throw new BoardException("글 목록 조회 실패", e);
        }
    }

    @Override
    public Board select(int board_id) throws BoardException {
        try {
            return boardDAO.select(board_id);
        } catch (DataAccessException e) {
            throw new BoardException("게시글 조회 실패", e);
        }
    }

    @Override
    public void create(Board board) throws BoardException {
        try {
            boardDAO.insert(board);
            //이 서비스 객체가 특정 DB 연동 기술에 국한된 것이 아니라, 모든 기술에 중립적이어야 하므로,
            //exception 객체조차도 상위의 중립적인 예외일수록 서비스 계층이 유연해질 수 있다.
        } catch (DataAccessException e) {
            throw new BoardException("글 등록 실패", e);
        }
    }

    @Override
    public Board update(Board board) throws BoardException {
        try {
            return boardDAO.update(board);
        } catch (DataAccessException e) {
            throw new BoardException("글 수정 실패", e);
        }
    }

    @Override
    public void delete(int board_id) throws BoardException {
        try {
            boardDAO.delete(board_id);
        } catch (DataAccessException e) {
            throw new BoardException("글 삭제 실패", e);
        }
    }
}
