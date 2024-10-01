package com.coding404.myweb.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsersVO<T> { // 전달되는 게 매번 바뀐다면
    private String id;
    private String pw;
    private String name;

    // 1:N
    // N쪽 데이터를 list로 담는다
    private ArrayList<T> memoList; // <> 제네릭 타입으로도 쓸 수 있음
}
