package com.itheima.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.dao.CustDaoImpl7;

public class ListCustServlet7 extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.�����в�ѯ���еķ���,���ҵ�����
		CustDaoImpl7 custDaoImpl7 = new CustDaoImpl7();
		
//		List<Cust> list = custDaoImpl1.getAllCust();
//		//2.�����ҵ�����Ϣ����request��,����ת����listCust.jspҳ�����չʾ
//		request.setAttribute("list", list);
		request.getRequestDispatcher("/listCust7.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
