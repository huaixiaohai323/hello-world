package com.itheima.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.itheima.dao.CustDaoImpl1;
public class DelCustServlet3 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CustDaoImpl1 custDaoImpl1 = new CustDaoImpl1();
		//1.��ȡҪɾ���Ŀͻ�id
		String id = request.getParameter("id");
		//2.����Servcie�и���idɾ���ͻ��ķ���
		custDaoImpl1.delCustByID(id);
		//3.����ת�����ͻ��б�ҳ��
		request.getRequestDispatcher("/servlet/ListCustServlet3").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
