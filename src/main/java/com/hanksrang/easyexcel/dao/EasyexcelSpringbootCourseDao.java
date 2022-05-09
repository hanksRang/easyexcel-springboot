package com.hanksrang.easyexcel.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hanksrang.easyexcel.entity.EasyexcelSpringbootCourseEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 
 * 
 * @author 
 * @email @gmail.com
 * @date 2022-05-09 16:34:37
 */
@Mapper
public interface EasyexcelSpringbootCourseDao extends BaseMapper<EasyexcelSpringbootCourseEntity> {

    /**
    *  根据实体类查询
    * */
    List<EasyexcelSpringbootCourseEntity> query(EasyexcelSpringbootCourseEntity easyexcelSpringbootCourse);

}
