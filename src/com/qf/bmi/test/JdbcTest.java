package com.qf.bmi.test;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.UUID;

import com.qf.bmi.pojo.Record;

import java.sql.PreparedStatement;

import java.sql.Connection;

/**
 * ���ݿ����Ӳ���
 * @author ֣����
 *
 */
public class JdbcTest {
	public static void main(String[] args) throws Exception{
		
		//��������
		Class.forName("com.mysql.jdbc.Driver");//����·��
		//��ȡ����
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bmi","root","1124");
		//System.out.println(connection);
		//�����������
		//ɾ�����ݿ�����
		PreparedStatement ps =connection.prepareStatement("delete from b where id=?");
		ps.setString(1, "ab54");
		int i =ps.executeUpdate();
		if(i>0) {
			System.out.println("ɾ���ɹ���");
		}
		//�޸����ݿ�����
//		PreparedStatement ps =connection.prepareStatement("update b set height=? where id=?");
//		ps.setDouble(1, 200);
//		ps.setString(2, "ab54");
//		int i=ps.executeUpdate();
//		if(i>0) {
//			System.out.println("�޸ĳɹ�");
//		}
		//�����ݿ��������
//		PreparedStatement ps =connection.prepareStatement("insert into b(id,time,height,weight,sex,bmi,dream_value) values(?,?,?,?,?,?,?)");
//		String id =UUID.randomUUID().toString().substring(0,4);
//		ps.setString(1, id);
//		ps.setString(2, "2018-6-26");
//		ps.setDouble(3, 170);
//		ps.setDouble(4, 50);
//		ps.setString(5, "1");
//		ps.setDouble(6, 22.2);
//		ps.setDouble(7, 55);
//		
//		int i =ps.executeUpdate();
//		if(i>0) {
//			System.out.println("��ӳɹ�!");
//		}
		
		
		//��ѯ���ݿ�
		//		PreparedStatement ps =  connection.prepareStatement("select * from b");
//		//ִ��SQL
//		ResultSet resultSet = ps.executeQuery();
//		//��������
//		while(resultSet.next()) {
//			String id =resultSet.getString("id");
//			String time =resultSet.getString("time");
//			double height=resultSet.getDouble("height");
//			double weight=resultSet.getDouble("weight");
//			String sex =resultSet.getString("sex");
//			double bmi=resultSet.getDouble("bmi");
//			double dream_value=resultSet.getDouble("dream_value");
//			Record record=new Record(id, time, height, weight, sex, bmi, dream_value);
//			System.out.println(record);
//			
//		}
//		//�ر���(���ж�resultSet,ps,connection�Ƿ�Ϊ��)
//		resultSet.close();
//		ps.close();
//		connection.close();
	}
}
