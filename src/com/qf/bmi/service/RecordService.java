package com.qf.bmi.service;

import java.util.List;

import com.qf.bmi.pojo.Message;
import com.qf.bmi.pojo.Record;

/**
 * ��¼��ҵ��ӿ�
 * @author ֣����
 *
 */
public interface RecordService {

	List<Record> findAll();

	Message deleteById(String rId);

	void addRecord(Record record);



	

}
