package com.itheima.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.dao.CustDaoImpl7;

public class DelCustServlet7 extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CustDaoImpl7 custDaoImpl7 = new CustDaoImpl7();
		//1.��ȡҪɾ���Ŀͻ�id
		String id = request.getParameter("id");
		//2.����Servcie�и���idɾ���ͻ��ķ���
		custDaoImpl7.delCustByID(id);
		//3.����ת�����ͻ��б�ҳ��
		request.getRequestDispatcher("/servlet/ListCustServlet7").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
