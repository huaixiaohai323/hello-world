package com.itheima.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.itheima.dao.CustDaoImpl5;
import com.itheima.domain.Cust;

public class FindCustByCondServlet5 extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{
			request.setCharacterEncoding("utf-8");
			CustDaoImpl5 custDaoImpl5 = new CustDaoImpl5();
			//1.��ȡ��ѯ������װ��bean��
			Cust cust = new Cust();
			BeanUtils.populate(cust, request.getParameterMap());
			//2.����Service��������ѯ�ͻ��ķ���,������������Ŀͻ�
			List<Cust> list = custDaoImpl5.findCustByCond(cust);
			//3.���鵽�Ŀͻ�����request���д���listCust.jspҳ�����չʾ
			request.setAttribute("list", list);
			request.getRequestDispatcher("/listCust5.jsp").forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}