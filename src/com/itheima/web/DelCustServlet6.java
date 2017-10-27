package com.itheima.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.service.CustService;
import com.itheima.service.CustServiceImpl6;

public class DelCustServlet6 extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CustService service = new CustServiceImpl6();
		//1.��ȡҪɾ���Ŀͻ�id
		String id = request.getParameter("id");
		//2.����Servcie�и���idɾ���ͻ��ķ���
		service.delCustByID(id);
		//3.����ת�����ͻ��б�ҳ��
		request.getRequestDispatcher("/servlet/ListCustServlet").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
