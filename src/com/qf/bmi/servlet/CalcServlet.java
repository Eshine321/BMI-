package com.qf.bmi.servlet;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.qf.bmi.pojo.Record;
import com.qf.bmi.service.RecordService;
import com.qf.bmi.service.impl.RecordServiceImpl;
import com.qf.bmi.utlis.Calc_Utils;

/**
 * Servlet implementation class CalcServlet
 */
@WebServlet("/servlet/CalcServlet")
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		Double height =Double.valueOf(request.getParameter("height"));
		Double weight =Double.valueOf(request.getParameter("weight"));
		String sex = request.getParameter("sex");
		double bmi = Calc_Utils.calcBmi(height, weight);
		double dream_value = Calc_Utils.calcDream(height);
		String time = Calc_Utils.getTime();
		String id = UUID.randomUUID().toString().substring(0,4);
		Record record = new Record(id, time, height, weight, sex, bmi, dream_value);
		RecordService recordService = new RecordServiceImpl();
		try {
			recordService.addRecord(record);
			String json=new Gson().toJson(record);
			response.getWriter().print(json);
		} catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
