package com.fzu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fzu.entity.Student;
import com.fzu.mapper.StudentMapper;
import com.fzu.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService  {

    @Override
    public List<Student> getAbsentList() {
        List<Student> studentList = this.list();
        studentList.removeIf(student -> (student.getValidCnt() == 0 || student.getConsecutiveAttendCnt()>2));
        return studentList;
    }

    @Override
    public void updateValidCntByIdList(List<Integer> idList) {
        for (Integer id : idList) {
            Student student = this.getById(id);
            student.setValidCnt(student.getValidCnt()+1);
            this.updateById(student);
        }
    }

    @Override
    public void initConsecutiveAttendCntByIdList(List<Integer> idList) {
        for (Integer id : idList) {
            Student student = this.getById(id);
            student.setConsecutiveAttendCnt(0);
            this.updateById(student);
        }
    }

    @Override
    public void updateConsecutiveAttendCntByIdList(List<Integer> studentId) {
        for (Integer id : studentId) {
            Student student = this.getById(id);
            student.setConsecutiveAttendCnt(student.getConsecutiveAttendCnt()+1);
            this.updateById(student);
        }
    }
}
