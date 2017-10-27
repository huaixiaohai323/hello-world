package com.itheima.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.domain.Page;
import com.itheima.service.CustServiceImpl4;

public class PageCustServlet4 extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		CustService service = BasicFactory.getFactory().getInstance(CustService.class);
		CustServiceImpl4 service = new CustServiceImpl4();
		//1.��ȡ��ǰҪ��ʾ��ҳ��ÿҳ��¼��
		int thispage = Integer.parseInt(request.getParameter("thispage"));
		int rowperpage = 100;
		//2.����Service�з�ҳ��ѯ�ͻ��ķ���,���ҳ��ͻ���Ϣ
		Page page = service.pageCust(thispage,rowperpage);
		//3.����request����,����pageList.jspҳ���н�����ʾ
		request.setAttribute("page", page);
		request.getRequestDispatcher("/pageList4.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
