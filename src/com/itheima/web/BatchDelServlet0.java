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

public class BatchDelServlet0 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CustDaoImpl0 custDaoImpl0 = new CustDaoImpl0();
		//1.��ȡ����Ҫɾ���Ŀͻ�id
		String [] ids = request.getParameterValues("delId");
		//2.����Service������ɾ���ͻ��ķ���
		custDaoImpl0.batchDel(ids);
		//3.ת�����ͻ��б�ҳ��
		request.getRequestDispatcher("/servlet/ListCustServlet0").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
