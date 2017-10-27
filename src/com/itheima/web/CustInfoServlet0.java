package com.itheima.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.itheima.dao.CustDaoImpl0;
import com.itheima.domain.Cust;

public class CustInfoServlet0 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CustDaoImpl0 custDaoImpl0 = new CustDaoImpl0();
		//1.��ȡҪ��ѯ�Ŀͻ�id
		String id = request.getParameter("id");
		//2.����Service�и���id���ҿͻ��ķ���
		Cust cust = custDaoImpl0.findUserById(id);
		if(cust == null){
			throw new RuntimeException("�Ҳ����ÿͻ�!");
		}
		//3.�����ҵ��Ŀͻ���Ϣ����request����,����ת����updateCust.jspҳ��չʾ
		request.setAttribute("cust", cust);
		request.getRequestDispatcher("/updateCust0.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}


}
