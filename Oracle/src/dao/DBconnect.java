package dao;

import java.sql.*;

public class DBconnect {
	
	private Connection conn = null;

	String url = "jdbc:oracle:thin:@127.0.0.1:59162:xe";
	String user = "scott";
	String pass = "tiger";
	
	public Connection getConnection() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");


			conn = DriverManager.getConnection(url, user, pass);
			System.out.println("커넥션 성공");

		} catch (ClassNotFoundException e) {

			e.printStackTrace();

		} catch (SQLException e) {

			e.printStackTrace();

		}
		return conn;
	}
	public void close(Connection conn, PreparedStatement ps, ResultSet rs) {
		try {
			if(conn != null) {
				conn.close();
			}
			if(ps != null) {
				ps.close();
			}
			if(rs != null) {
				rs.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void close(Connection conn, PreparedStatement ps) {
		try {
			if(conn != null) {
				conn.close();
			}
			if(ps != null) {
				ps.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
