package com.lbc.hyx.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

@Controller
public class AipController {
	@Autowired
	@Qualifier("primaryJdbcTemplate")
	JdbcTemplate primaryJdbcTemplate;

	@Autowired
	@Qualifier("secondaryJdbcTemplate")
	JdbcTemplate secondaryJdbcTemplate;


	@RequestMapping("/home.action")
	public String home(){
		return "/";
	}

	/**
	 * 返回videocasecollect页面
	 * @return
	 */
	@RequestMapping("/videocaserecords")
	public String videocaserecords(Model model) {
		return "videocaserecords";
	}

	/**
	 * 返回videocasecollect页面
	 * @return
	 */
	@RequestMapping("/videocasecollect")
	public String videocasecollect(Model model) {
		return "videocasecollect";
	}

	/**
	 * 返回videocasestatistics页面
	 * @return
	 */
	@RequestMapping("/videocasestatistics")
	public String videocasestatistics(Model model) {
		return "videocasestatistics";
	}
	/**
	 * 测试
	 * @return
	 */
	@RequestMapping("/easytest")
	public String feedmanager(Model model) {
		return "easytest";
	}


	/**
	 * 测试
	 * @return
	 */
	@RequestMapping("/index")
	public String index(Model model) throws SQLException {
		DatabaseMetaData metaData = primaryJdbcTemplate.getDataSource().getConnection().getMetaData();
		ResultSet tables = metaData.getTables(null, null, null, new String[]{"TABLE"});
		while (tables.next()){
			System.out.println("表名：" + tables.getString(3));
		}
		System.out.println("-------------------------------------------------------------");

		DatabaseMetaData metaData1 = secondaryJdbcTemplate.getDataSource().getConnection().getMetaData();
		ResultSet tables1 = metaData1.getTables(null, null, null, new String[]{"TABLE"});
		while (tables1.next()){
			System.out.println("表名：" + tables1.getString(3));
		}

		return "index";
	}
}
