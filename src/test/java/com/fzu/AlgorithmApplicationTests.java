package com.fzu;

import com.fzu.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class AlgorithmApplicationTests {

    @Autowired
    private StudentService studentService;
    @Test
    void contextLoads() {
        System.out.println(studentService.list());

    }

}
