package com.qf.bmi.service;

import java.util.List;

import com.qf.bmi.pojo.Message;
import com.qf.bmi.pojo.Record;

/**
 * 记录的业务接口
 * @author 郑其鑫
 *
 */
public interface RecordService {

	List<Record> findAll();

	Message deleteById(String rId);

	void addRecord(Record record);



	

}
