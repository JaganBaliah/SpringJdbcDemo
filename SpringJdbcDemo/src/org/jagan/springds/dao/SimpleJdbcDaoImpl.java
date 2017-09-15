package org.jagan.springds.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class SimpleJdbcDaoImpl extends JdbcDaoSupport {

	public int getCircleCount() {
		String sql = "SELECT count(*) from Circle";
		return this.getJdbcTemplate().queryForObject(sql, Integer.class);
	}
	
}
