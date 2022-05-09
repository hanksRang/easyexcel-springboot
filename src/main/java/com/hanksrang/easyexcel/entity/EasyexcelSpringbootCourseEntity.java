package com.hanksrang.easyexcel.entity;

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
	private Long id;
	/**
	 * 
	 */
	private String name;
	/**
	 * 
	 */
	private Double score;

}
