package com.sinse.practiceapp.pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class PoolManager {
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/spring4";
	private String user = "spring4";
	private String pass = "1234";
	private static PoolManager instance;
	Vector<Connection> connectionPool = new Vector<>();
	
	private PoolManager() {
	}
	
	public static PoolManager getInstance() {
		if(instance == null) {
			instance = new PoolManager();
		}
		
		return instance;
	}
	
	public void createConnection() {
		for(int i=0; i<20; i++) {
			try {
				Class.forName(driver);
				Connection con = DriverManager.getConnection(url, user, pass);
				connectionPool.add(con);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public Connection getConnection() {
		if(connectionPool.isEmpty()) {
			createConnection();
		}
		return connectionPool.remove(0);
	}
	
	public void release(Connection con) {
		if(con != null) {
			connectionPool.add(con);
		}
	}
	public void release(Connection con, PreparedStatement pstmt) {
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(con != null) {
			connectionPool.add(con);
		}
	}
	public void release(Connection con, PreparedStatement pstmt, ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(con != null) {
			connectionPool.add(con);
		}
	}
}
