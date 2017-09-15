package org.jagan.springds.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.jagan.springds.model.Circle;

public class JdbcClassicDaoImpl {

	public Circle getCircle(int circleId) {
		Circle rtnVal = null;
		Connection conn = null;
		try {
			String driver = "org.apache.derby.jdbc.ClientDriver";
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection("jdbc:derby://localhost:1527/db");
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
