package com.itheima.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.dao.CustDaoImpl0;
import com.itheima.service.CustService;
import com.itheima.service.CustServiceImpl;

public class DelCustServlet0 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CustDaoImpl0 custDaoImpl0 = new CustDaoImpl0();
		//1.��ȡҪɾ���Ŀͻ�id
		String id = request.getParameter("id");
		//2.����Servcie�и���idɾ���ͻ��ķ���
		custDaoImpl0.delCustByID(id);
		//3.����ת�����ͻ��б�ҳ��
		request.getRequestDispatcher("/servlet/ListCustServlet0").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
