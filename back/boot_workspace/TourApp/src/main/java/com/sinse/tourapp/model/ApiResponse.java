package com.sinse.tourapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ApiResponse {
    private List<Datum> data;
    private int pageNo;
    private int currentCount;
    private String resultCode;
    private int totalCount;
    private int numOfRows;
    private String resultMsg;

    @Data
    public static class Datum {
        private int tourNo;                      //No
        private String tourNm;                 //관광지명
        private String tourGubun;             //투어구분
        private String newAddr;               //신도로명 주소
        private String oldAddr;                 //구도로명 주소
        private double latitude;                //위도
        private double longtitude;             //경도
        private String area;                     //면적
        private String convenienceFacility; //편의시설
        private String accommodations;     //숙소
        private String amusementFacility;   //자연경관
        private String recreationalFacility;   //휴양시설
        private String receptionFacility;      //
        private String supportFacility;         //
        private String designationDt;          //준공일자
        private int accommodatedNum;       //수용인원
        private int parkinglotNum;              //주차장번호
        private String info;                       //관광지 정보
        private String managementNum;      //관리자 연락처
        private String managementNm;        //관리지역
        private String updateDt;                 //수정일자
    }

    @Data
    public static class Header {

    }
}
