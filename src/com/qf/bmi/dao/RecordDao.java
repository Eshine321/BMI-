package com.qf.bmi.dao;

import java.util.List;

import com.qf.bmi.pojo.Record;

/**
 * 数据操作层Dao接口
 * @author 郑其鑫
 *
 */
public interface RecordDao {

	List<Record> findAll();

	int deleteById(String rId);

	void addRecord(Record record);

	



}
