package com.itheima.web;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.itheima.dao.CustDaoImpl0;
import com.itheima.domain.Cust;

public class ListCustServlet0 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.�����в�ѯ���еķ���,���ҵ�����
		CustDaoImpl0 custDaoImpl0 = new CustDaoImpl0();
		
//		List<Cust> list = custDaoImpl0.getAllCust();
//		//2.�����ҵ�����Ϣ����request��,����ת����listCust.jspҳ�����չʾ
//		request.setAttribute("list", list);
		request.getRequestDispatcher("/listCust0.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
