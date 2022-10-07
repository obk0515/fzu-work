package com.fzu.utils;

import com.fzu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RollCall {
    @Autowired
    private StudentService studentService;

    public List<String> getProgramme(){
        studentService.getMap(null);
        return null;
    }
}
