package com.itheima.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.dao.CustDaoImpl4;

public class BatchDelServlet4 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CustDaoImpl4 custDaoImpl4 = new CustDaoImpl4();
		//1.��ȡ����Ҫɾ���Ŀͻ�id
		String [] ids = request.getParameterValues("delId");
		//2.����Service������ɾ���ͻ��ķ���
		custDaoImpl4.batchDel(ids);
		//3.ת�����ͻ��б�ҳ��
		request.getRequestDispatcher("/servlet/ListCustServlet4").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
