package com.coding404.myweb;

import com.coding404.myweb.command.ProductVO;
import com.coding404.myweb.product.ProductMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestCode01 {
    /*
    @Autowired
    ProductMapper productMapper;

    @Test
    public void insertTest() {
        for (int i = 1; i <= 300; i++) {
            ProductVO vo = ProductVO.builder()
                    .prodEnddate("2024-09-15")
                    .prodWriter("admin")
                    .prodName("coding" + i)
                    .prodPrice(i * 100)
                    .prodCount(i * 10)
                    .prodDiscount(i)
                    .prodPurchaseYn("N")
                    .prodContent("coding" + i)
                    .prodComment("coding" + i)
                    .build();
            productMapper.productInsert(vo);
        }
    }
    */
}
