package com.qf.bmi.utlis;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.management.RuntimeErrorException;

import java.io.Closeable;
import java.sql.Connection;

/**
 * jdbc������
 * @author ֣����
 *
 */
public class JDBC_Utils {
	private static final String driver="com.mysql.jdbc.Driver";
	private static final String url="jdbc:mysql://localhost:3306/bmi";
	private static final String uName="root";
	private static final String uPwd="root";
	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("��ȡ�����쳣!");
		}
	}
	//��ȡ��������
	public static Connection getConnection() {
		try {
			Connection connection=DriverManager.getConnection(url,uName,uPwd);
			return connection;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("��ȡ�����쳣!");
		}
	}
	/*
	 * ��ɾ�Ĳ鷽��*/
	//��������
	public static int executeUpdate(String sql,Object...params) {
		Connection connection=getConnection();
		PreparedStatement ps=null;
		try {
			ps=connection.prepareStatement(sql);
			for(int i=0;i<params.length;i++) {
				ps.setObject(i+1, params[i]);
			}
			int i=ps.executeUpdate();
			return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("�����쳣!");
		}finally {
			close(null, ps, connection);
		}
	}

	/*
	 * �ر���*/
	public static void close(ResultSet resultSet,PreparedStatement ps,Connection connection) {
		if(resultSet!=null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(ps!=null) {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		if(connection!=null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}