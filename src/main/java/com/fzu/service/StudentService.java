package com.fzu.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.fzu.entity.Student;

import java.util.List;

public interface StudentService extends IService<Student> {
    List<Student> getAbsentList();

    void updateValidCntByIdList(List<Integer> idList);

    void initConsecutiveAttendCntByIdList(List<Integer> idList);

    void updateConsecutiveAttendCntByIdList(List<Integer> studentId);
}
