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

    /**
     * 获取缺勤学生列表
     * @return
     */
    @Override
    public List<Student> getAbsentList() {
        List<Student> studentList = this.list();
        studentList.removeIf(student -> (student.getValidCnt() == 0 || student.getConsecutiveAttendCnt()>2));
        return studentList;
    }

    /**
     * 更新被点到缺勤次数
     * @param idList
     */
    @Override
    public void updateValidCntByIdList(List<Integer> idList) {
        for (Integer id : idList) {
            Student student = this.getById(id);
            student.setValidCnt(student.getValidCnt()+1);
            this.updateById(student);
        }
    }

    /**
     * 初始化被点到但有出勤次数
     * @param idList
     */
    @Override
    public void initConsecutiveAttendCntByIdList(List<Integer> idList) {
        for (Integer id : idList) {
            Student student = this.getById(id);
            student.setConsecutiveAttendCnt(0);
            this.updateById(student);
        }
    }

    /**
     * 更新被点到但有出勤次数
     * @param studentId
     */
    @Override
    public void updateConsecutiveAttendCntByIdList(List<Integer> studentId) {
        for (Integer id : studentId) {
            Student student = this.getById(id);
            student.setConsecutiveAttendCnt(student.getConsecutiveAttendCnt()+1);
            this.updateById(student);
        }
    }
}
