package com.lbc.hyx.dao.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @Entity:注明这是一个和数据库表映射的实体类
 *
 */
@Entity
@Data
public class Person {
	@Id//指明这个属性映射数据库主键
	@GeneratedValue//自增主键
	private Long id;
	private String name ;
	private Integer age;
	private String address;

}
