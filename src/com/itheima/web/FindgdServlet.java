package com.itheima.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.itheima.dao.PaigongdanDaoImpl;
import com.itheima.domain.PaigongdanS;

public class FindgdServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response){
		try{
			request.setCharacterEncoding("utf-8");
			response.setHeader("Refresh", "3");
			PaigongdanDaoImpl pd = new PaigongdanDaoImpl();
			//����Service��������ѯ�ķ���
			PaigongdanS ps = pd.findById();
			//���鵽�Ŀͻ�����request���д���Main.jspҳ�����չʾ
			request.setAttribute("ps", ps);
			request.getRequestDispatcher("/Main.jsp").forward(request, response);
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
