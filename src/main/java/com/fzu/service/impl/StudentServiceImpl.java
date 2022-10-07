package com.fzu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fzu.entity.Student;
import com.fzu.mapper.StudentMapper;
import com.fzu.service.StudentService;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService  {
}
