package org.jagan.springds.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.jagan.springds.model.Circle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JdbcDataSourceDaoImpl {

	@Autowired
	private DataSource dataSource;
	
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public Circle getCircle(int circleId) {
		Circle rtnVal = null;
		Connection conn = null;
		try {
			conn = this.dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM circle where id = ?");
			ps.setInt(1, circleId);

			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				rtnVal = new Circle(circleId, rs.getString("name"));
			}
			rs.close();
			ps.close();
		} catch(Exception e) {
			System.out.println("Exception occured : " + e);			
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return rtnVal;
	}
	
}
