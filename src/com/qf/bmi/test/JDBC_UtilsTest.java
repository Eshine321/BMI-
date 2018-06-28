package com.qf.bmi.test;

import java.security.Policy.Parameters;
import java.sql.Connection;
import java.util.UUID;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.qf.bmi.pojo.Record;
import com.qf.bmi.utlis.JDBC_Utils;
public class JDBC_UtilsTest {
public static void main(String[] args) {
	//增加数据
	/*String sql="insert into b(id,time,height,weight,sex,bmi,dream_value) value(?,?,?,?,?,?,?)";
	String id=UUID.randomUUID().toString().substring(0,4);
	Object[] params = {id,"2018-06-26",190,80,"0",22.2,85};
	int i=JDBC_Utils.executeUpdate(sql,params);
	if(i>0) {
		System.out.println("添加成功");
	}*/
	//修改数据
	/*String sql="update b set height=? where id=?";
	Object[] params = {110,"001"};
	int i=JDBC_Utils.executeUpdate(sql,params);
	if(i>0) {
		System.out.println("修改成功");
	}*/
	//删除数据
	/*String sql="delete from b where id=?";
	Object[] params= {"001"};
	int i=JDBC_Utils.executeUpdate(sql,params);
	if(i>0) {
		System.out.println("删除成功");
	}*/
	//查询数据
	String sql="select * from b";
	Connection connection=JDBC_Utils.getConnection();
	PreparedStatement ps=null;
	ResultSet resultSet=null;
	try {
		ps=connection.prepareStatement(sql);
		resultSet=ps.executeQuery();
		while(resultSet.next()) {
			String id =resultSet.getString("id");
			String time =resultSet.getString("time");
			double height=resultSet.getDouble("height");
			double weight=resultSet.getDouble("weight");
			String sex =resultSet.getString("sex");
			double bmi=resultSet.getDouble("bmi");
			double dream_value=resultSet.getDouble("dream_value");
			Record record=new Record(id, time, height, weight, sex, bmi, dream_value);
			System.out.println(record);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		JDBC_Utils.close(resultSet, ps, connection);
	}
}
}
