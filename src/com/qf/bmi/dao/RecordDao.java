package com.qf.bmi.dao;

import java.util.List;

import com.qf.bmi.pojo.Record;

/**
 * ���ݲ�����Dao�ӿ�
 * @author ֣����
 *
 */
public interface RecordDao {

	List<Record> findAll();

	int deleteById(String rId);

	void addRecord(Record record);

	



}
