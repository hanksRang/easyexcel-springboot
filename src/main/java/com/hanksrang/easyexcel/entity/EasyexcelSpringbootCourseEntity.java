package com.hanksrang.easyexcel.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author 
 * @email @gmail.com
 * @date 2022-05-09 16:34:37
 */
@Data
@TableName("easyexcel_springboot_course")
public class EasyexcelSpringbootCourseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(type = IdType.AUTO)
	@ExcelProperty("主键")
	private Long id;
	/**
	 * 
	 */
	@ExcelProperty("课程名")
	private String name;
	/**
	 * 
	 */
	@ExcelProperty("学分")
	private Double score;

}
