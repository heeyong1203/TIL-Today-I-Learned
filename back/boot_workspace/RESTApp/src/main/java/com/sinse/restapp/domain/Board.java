package com.sinse.restapp.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //jpa가 자체적으로 pk값을 증가시키는 것이 아닌 mysql의 pk 삽입 요청 어노테이션
    private int board_id;
    private String title;
    private String writer;
    private String content;

    @Column(name = "regdate", insertable = false, updatable = false)
    private String regdate;
    private int hit;
}
