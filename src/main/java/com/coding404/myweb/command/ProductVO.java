package com.coding404.myweb.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor // 모든 필드를 인자로 받는 생성자를 자동으로 생성
@NoArgsConstructor // 매개변수가 없는 기본 생성자를 자동으로 생성
@Data // @Getter, @Setter, @ToString, @EqualsAndHashCode, @RequiredArgsConstructor 어노테이션들을 한꺼번에 묶어서 사용
@Builder // 객체를 생성할 때 필드 순서를 기억할 필요 없이, 메서드 체이닝을 통해 원하는 필드만 설정
public class ProductVO {

    private Integer prodId;
    private LocalDateTime prodRegdate;
    private String prodEnddate;
    private String prodCategory;
    private String prodWriter;
    private String prodName;
    private Integer prodPrice;
    private Integer prodCount;
    private Integer prodDiscount;
    private String prodPurchaseYn;
    private String prodContent;
    private String prodComment;

    // N:1조인 - 1쪽 컬럼을 추가함
    private String categoryNav;
}
