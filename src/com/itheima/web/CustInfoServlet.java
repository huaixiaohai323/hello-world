package com.itheima.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.itheima.domain.Cust;
import com.itheima.service.CustService;
import com.itheima.service.CustServiceImpl;

public class CustInfoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		CustService service = BasicFactory.getFactory().getInstance(CustService.class);
		CustService service = new CustServiceImpl();
		//1.��ȡҪ��ѯ�Ŀͻ�id
		String id = request.getParameter("id");
		//2.����Service�и���id���ҿͻ��ķ���
		Cust cust = service.findCustById(id);
		if(cust == null){
			throw new RuntimeException("�Ҳ����ÿͻ�!");
		}
		//3.�����ҵ��Ŀͻ���Ϣ����request����,����ת����updateCust.jspҳ��չʾ
		request.setAttribute("cust", cust);
		request.getRequestDispatcher("/updateCust.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
