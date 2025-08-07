package com.sinse.restapp.model.board;

import com.sinse.restapp.domain.Board;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("jpaBoardDAO")
public class JpaBoardDAO implements BoardDAO {

    //Hibernate의 경우 session 객체가 쿼리 수행 객체
    //JPA의 경우 EntityManager 객체가 쿼리 수행 객체
    //EntityManager는 최상위 인터페이스이므로, Hibernate를 사용할 경우에도 EntityManager를 쓸 수 있다.
    @PersistenceContext //JPA의 EntityManager를 자동으로 주입받는다.
    private EntityManager em;

    @Override
    public List<Board> selectAll() {
        //ORM에서의 select구절은 table명을 의미하는 것이 아닌 객체를 의미한다.
        //또한, SQL문의 select문이 아니다.
        return em.createQuery("select b from Board b").getResultList();
    }

    @Override
    public Board select(int board_id) {
        return em.find(Board.class,board_id);
    }

    @Override
    public void insert(Board board) {
        em.persist(board);
    }

    @Override
    //JPA 혹은 Hibernate는 수정된 결과를 추적하기 때문에 반환형을 void가 아닌 반환된 객체로 설정한다.
    public Board update(Board board) {
        return em.merge(board);
    }

    @Override
    public void delete(int board_id) {
        Board board = em.find(Board.class,board_id);//삭제 시 무조건 일치하는 pk를 지우는 것이 아니라,
        if(board!=null){                                        //실제 존재하는 데이터인지 우선 체크한 후
            em.remove(board);                               //삭제하는 것이 안전하다.
        }
    }
}
