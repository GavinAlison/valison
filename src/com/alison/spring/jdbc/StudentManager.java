package com.alison.spring.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

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

	// 删除信息
	public boolean deleteStudent(int id) {
		boolean flag = true;
		try {
			String sql = "delete  from student where studetnId=?";
			jdbcTemplate.update(sql, new Object[] { id },
					new int[] { Types.INTEGER });
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	// 根据ID更新信息
	public boolean updateStudetn(int id, Student student) {
		boolean flag = true;
		try {
			String sql = "update student set name=?, age=?, classRoom=? where id=?";
			jdbcTemplate.update(sql,
					new Object[] { student.getName(), student.getAge(),
							student.getClassRoom(), student.getId() },
					new int[] { Types.VARCHAR, Types.INTEGER, Types.VARCHAR,
							Types.INTEGER });
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	// 根据Id查询学生信息
	public Student getStudentObject(int id) {
		Student student = null;
		try {
			String sql = "select * from student where id = ?";
			return (Student) jdbcTemplate.queryForObject(sql,
					new Object[] { id }, new int[] { Types.INTEGER },
					new RowMapper<Student>() {
						public Student mapRow(ResultSet rs, int arg1)
								throws SQLException {
							Student student = null;
							student.setId(rs.getInt(1));
							student.setVersion(rs.getInt(2));
							student.setName(rs.getString(3));
							student.setAge(rs.getInt(4));
							student.setClassRoom(rs.getString(5));
							return student;
						}
					});
		}
		// 根据Id查询学生信息抛异常, 不管什么原因, 认为查询不到该学生信息, 返回null
		catch (DataAccessException e) {
		}
		return student;
	}
}
