package com.example.pichinchatest;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PichinchaTestApplication.class)
class PichinchaTestApplicationTests {

    @Test
    void contextLoads() {
        assertTrue(true);
    }

}
