package com.itheima.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.dao.CustDaoImpl5;

public class BatchDelServlet5 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CustDaoImpl5 custDaoImpl5 = new CustDaoImpl5();
		//1.��ȡ����Ҫɾ���Ŀͻ�id
		String [] ids = request.getParameterValues("delId");
		//2.����Service������ɾ���ͻ��ķ���
		custDaoImpl5.batchDel(ids);
		//3.ת�����ͻ��б�ҳ��
		request.getRequestDispatcher("/servlet/ListCustServlet5").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
