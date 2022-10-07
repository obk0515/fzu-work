package com.fzu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fzu.entity.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentMapper extends BaseMapper<Student> {
}
