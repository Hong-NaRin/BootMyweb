package com.coding404.myweb;

import com.coding404.myweb.command.MemoVO;
import com.coding404.myweb.command.UsersVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest // 애플리케이션의 통합 테스트를 위해 사용
public class TestCode02 {

    //조인에 대한 처리 예제

    @Autowired // Spring의 의존성 주입
    TestMapper testMapper;

//    @Test
//    public void joinTest01() {
//        ArrayList<MemoVO> list = testMapper.joinOne(); // n:1조인
//        System.out.println(list.toString());
//    }

    @Test // JUnit에서 테스트 메서드
    public void joinTest02() {
        UsersVO vo = testMapper.joinTwo();
        System.out.println(vo.toString());
    }
}
