package com.coding404.myweb.util;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Data // getter, setter
public class PageVO {

    // 화면에 그려질 pageNation을 계산하는 클래스
    private int start; // 시작 페이지 번호
    private int end; // 마지막 페이지 번호
    private boolean prev; // 이전 버튼
    private boolean next; // 다음 버튼

    private int page; // 현재 조회하는 페이지 번호 <-- cri
    private int amount; // 현재 조회하는 데이터 개수 <-- cri
    private int total; // 전체 게시글 수
    private int realEnd; // 맨 마지막 페이지에 도달했을 때, 재계산이 들어가는 실제 끝번호

    private Criteria cri; // 페이징 기준
    private List<Integer> pageList; // 페이지네이션 번호를 list로 생성

    private int pageSize = 5; //페이지네이션 크기

    // 생성자 - 생성될 때 criteria객체, 전체 게시글 수를 받는다
    public PageVO(Criteria cri, int total) {
        this.page = cri.getPage();
        this.amount = cri.getAmount();
        this.total = total;
        this.cri = cri;

        // 끝 페이지 번호 계산
        // 끝 페이지 = (페이지번호 / 페이지네이션 수) * 페이지네이션수
        // 1~10번 페이지 조회시 -> 10
        // 11~20번 페이지 조회시 -> 20
        this.end = (int)Math.ceil(this.page / (double)this.pageSize) * this.pageSize;

        // 시작 페이지 번호 계산
        // 시작페이지 =  끝번호 - 페이지네이션 + 1
        this.start = end - this.pageSize + 1;

        // 실제 끝번호 재계산
        // 총 게시물 개수가 53개 -> 실제 끝번호 6, end 페이지 10
        // 총 게시물 개수가 112개 -> 실제 끝번호 12, end 페이지 20
        // 실제 끝번호 = 올림(총 게시물 개수 / 조회하는 데이터 개수)
        this.realEnd = (int)Math.ceil(this.total / (double)this.amount);

        // end 재계산
        // 112개 게시물 -> 1~10 페이지번호를 볼 때는 end=10, realEnd=12 -> end를 따라감
        //           -> 11~20 페이지번호를 볼 때는 end=20, realEnd=12 -> realEnd를 따라감
        // end가 realEnd보다 크면 realEnd를 따라간다
        // if(end > realEnd) this.end = this.realEnd;
        this.end = end > realEnd ? realEnd : end;

        // 이전 버튼 활성화 여부
        // start값의 증가는 1, 11, 21, 31... -> strat가 1보다 크면 이전 버튼 활성화
        this.prev = this.start > 1;
        // 다음 버튼 활성화 여부
        this.next = this.realEnd > this.end;

        // 페이지네이션 생성
        this.pageList = IntStream.rangeClosed(this.start, this.end).boxed().collect(Collectors.toList()); }
}
