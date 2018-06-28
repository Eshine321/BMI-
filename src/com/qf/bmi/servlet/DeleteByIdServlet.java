package com.qf.bmi.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.qf.bmi.pojo.Message;
import com.qf.bmi.service.RecordService;
import com.qf.bmi.service.impl.RecordServiceImpl;


@WebServlet("/servlet/DeleteByIdServlet")
public class DeleteByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String rId = request.getParameter("rId");
		RecordService recordService=new RecordServiceImpl();
		Message msg=recordService.deleteById(rId);
		String json=new Gson().toJson(msg);
		response.getWriter().println(json);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
