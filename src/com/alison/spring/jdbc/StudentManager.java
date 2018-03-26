package com.alison.spring.jdbc;

import org.hsqldb.Types;
import org.springframework.jdbc.core.JdbcTemplate;

public class StudentManager {
	private JdbcTemplate jdbcTemplate;

	private static StudentManager instance = new StudentManager();

	public static StudentManager getInstance() {
		return instance;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	// 添加信息
	public boolean addStudent(Student student) {
		try {
			String sql = "insert into student values(null, 0, ? , ?, ? )";
			jdbcTemplate.update(sql, new Object[] { student.getName(),
					student.getAge(), student.getClassRoom() }, new int[] {
					Types.VARCHAR, Types.INTEGER, Types.VARCHAR });
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
