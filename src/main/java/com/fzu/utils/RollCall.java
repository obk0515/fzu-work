package com.fzu.utils;

import com.fzu.entity.Student;
import com.fzu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RollCall {
    @Autowired
    private StudentService studentService;


    /**
     * 获取点名方案
     * @param classNumber
     * @return
     */
    public List<Student> getProgramme(int classNumber){
        if (classNumber==1){
            return studentService.list();
        }else{
            List<Student> absentList=studentService.getAbsentList();
            return absentList;
        }
    }

    /**
     * 根据获取点名方案
     * @param classNumber
     * @return
     */
    public List<Student> getProgrammeByScore(int classNumber){
        if (classNumber==1){
            List<Student> studentList = studentService.list();
            studentList.removeIf(student -> student.getScorePosition()<=80);
            return studentList;
        }else{
            List<Student> absentList=studentService.getAbsentList();
            return absentList;
        }
    }

    /**
     * 更新学生表中学生缺勤信息
     * @param idList
     */
    public void updateAbsent(List<Integer> idList){
        studentService.updateValidCntByIdList(idList);
        studentService.initConsecutiveAttendCntByIdList(idList);
    }
}
