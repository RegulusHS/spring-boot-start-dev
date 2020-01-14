package com.example;

import com.example.service.OmsCartItemService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SpringBootDemoApplicationTests {

    @Autowired
    OmsCartItemService omsCartItemService;

    @Test
    void contextLoads() {
        Object o = omsCartItemService.find("12");
        System.out.println(o);
    }

}
