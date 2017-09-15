package org.jagan.springds.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.jagan.springds.model.Circle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

@Component
public class JdbcDaoImpl {

	private DataSource dataSource;
	
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	
	public int getCircleCount() {
		String sql = "SELECT count(*) FROM circle";
		return this.jdbcTemplate.queryForObject(sql, Integer.class);
	}

	public String getCircleName(int circleId) {
		String sql = "SELECT name FROM circle where id = ?";
		return this.jdbcTemplate.queryForObject(sql, new Object[] {circleId}, String.class);		
	}
	
	public Circle getCircleForId(int circleId) {
		String sql = "SELECT * FROM circle where id = ?";
		return this.jdbcTemplate.queryForObject(sql, new Object[] {circleId}, new CircleMapper());		
	}
	
	public List<Circle> getAllCircles() {
		String sql = "SELECT * FROM circle";
		return this.jdbcTemplate.query(sql, new CircleMapper());
	};

	public void insertCircle(Circle circle) {
		String sql = "INSERT into circle (ID, NAME) values(:id, :name)";
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource("id", circle.getId()).addValue("name", circle.getName());
		this.namedParameterJdbcTemplate.update(sql, sqlParameterSource);
	}
	
	public void insertCircleClassic(Circle circle) {
		String sql = "INSERT into circle (ID, NAME) values(?, ?)";
		this.jdbcTemplate.update(sql, new Object[] {circle.getId(), circle.getName()});
	}
	
	public void createTriangleTable() {
		String sql = "CREATE TABLE TRIANGLE (ID INTEGER, NAME VARCHAR(50))";
		this.jdbcTemplate.execute(sql);
	}
	
	private static final class CircleMapper implements RowMapper<Circle> {
		@Override
		public Circle mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			return new Circle(resultSet.getInt("ID"), resultSet.getString("NAME"));
		}
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		return namedParameterJdbcTemplate;
	}

	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}	
}