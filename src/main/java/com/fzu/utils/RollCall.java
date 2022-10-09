package com.fzu.utils;

import com.fzu.entity.Student;
import com.fzu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RollCall {
    @Autowired
    private StudentService studentService;


    public List<Student> getProgramme(int classNumber){
        if (classNumber==1){
            return studentService.list();
        }else{
            List<Student> absentList=studentService.getAbsentList();
            return absentList;
        }
    }

    public void updateAbsent(List<Integer> idList){
        studentService.updateValidCntByIdList(idList);
        studentService.initConsecutiveAttendCntByIdList(idList);
    }
}
