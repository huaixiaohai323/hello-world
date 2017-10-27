package com.itheima.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.domain.Cust;
import com.itheima.service.CustService;
import com.itheima.service.CustServiceImpl6;

public class ListCustServlet6 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		CustService service = BasicFactory.getFactory().getInstance(CustService.class);
		CustService service = new CustServiceImpl6();
		//1.����Service�в�ѯ���пͻ��ķ���,���ҵ����пͻ�
//		List<Cust> list = service.getAllCust();
//		//2.�����ҵ�����Ϣ����request��,����ת����listCust.jspҳ�����չʾ
//		request.setAttribute("list", list);
		request.getRequestDispatcher("/listCust.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
