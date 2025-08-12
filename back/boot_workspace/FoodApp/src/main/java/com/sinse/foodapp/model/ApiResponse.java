package com.sinse.foodapp.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

//Open API로부터 받은 응답 정보를 담기 위한 객체
@Data
public class ApiResponse {
    private List<Body> body;
    private Header header;

    //Body를 정의 ( 내부 클래스로 정의한다. 왜? 분산시키면 유지관리 하기가 복잡할 수 있기 때문이다. )
    @Data
    public static class Body{
        private String SIGUN;     //관할 행정구역
        @JsonProperty("SIGUN")
        private String sigun;

        private double LO;         //위도
        @JsonProperty("LO")
        private double lo;

        private double LA;         //경도
        @JsonProperty("LA")
        private double la;

        private String MNMNU;   //메인 메뉴
        @JsonProperty("MNMNU")
        private String mnmnu;

        private String SE;          //부가설명
        @JsonProperty("SE")
        private String se;

        private String CMPNM;    //상호명
        @JsonProperty("CMPNM")
        private String cmpnm;

        private String MENU;      //메뉴
        @JsonProperty("MENU")
        private String menu;

        private String TELNO;     //연락처
        @JsonProperty("TELNO")
        private String telno;

        //private String _URL;       //URL
        @JsonProperty("_URL")
        @JsonAlias({"url", "URL"})
        private String url;

        private String ADRES;     //주소
        @JsonProperty("ADRES")
        private String adres;

        private String TIME;       //영업시간
        @JsonProperty("TIME")
        private String time;

        private String DC;          //업체상세설명
        @JsonProperty("DC")
        private String dc;
    }

    //Header를 정의
    @Data
    public static class Header{
        private int perPage;
        private String resultCode;
        private int totalRows;
        private int currentPage;
        private String resultMsg;
    }

}
