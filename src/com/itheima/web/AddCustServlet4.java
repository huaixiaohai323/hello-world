package com.itheima.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.dao.CustDaoImpl1;
import com.itheima.dao.CustDaoImpl5;
import com.itheima.dao.PaigongdanDaoImpl;
import com.itheima.domain.Cust;
import com.itheima.domain.Paigongdan;
import com.sun.org.apache.commons.beanutils.BeanUtils;

public class AddCustServlet4 extends HttpServlet {

	String xinghao4 = null;
	String pihao4 = null;
	String xingHp4 = null;
	String workerN4 = "6666";
	String Ng4 = null;
	int i=0;
	int ng=0;
	int zongshu;
	String zongshu4=null;
	String id1=null;
	String id2=null;
	String canshu=null;//У�����λ
	String Id = null;//���뻺����
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		List<String> names = new ArrayList<String>();
		Enumeration<String> em = request.getParameterNames();
		try{
			//�жϲ�Ʒ�����Ƿ����,������ڣ����£���������ڣ����
			while(em.hasMoreElements()){
				String name = em.nextElement();
				//ͨ��id�����ж��Ƿ��ǲ�Ʒ���룬����Ʒ������ӵ�������
				if(name.length()==12){
					CustDaoImpl1 custDaoImpl1 = new CustDaoImpl1();
					Cust cust0 = custDaoImpl1.findUserByProductid(name);
					try{
					if(cust0.getParame1p().equals("�ϸ�")){
						Id = name;
					}else{
						return;
					}
					}catch (Exception e) {
						return;
					}
					return;
				}else if(name.length()==6){//ͨ�����볤���ж�Ա������
					workerN4 = name;
					System.out.println(workerN4);
				}else if(name.equals("a")||name.equals("aa")){
					if(Id==null||Id.equals(id2)){
						response.getWriter().write("ar");
						return;
					}
					id1 = Id;
					Id = null;
					response.getWriter().write("abbbbb"+id1.substring(id1.length()-3, id1.length())+"r");
					return;
				}else if(name.equals("b")||name.equals("bb")){
					if(Id==null||Id.equals(id1)){
						response.getWriter().write("ar");
						return;
					}
					id2 = Id;
					Id = null;
					response.getWriter().write("accccc"+id2.substring(id2.length()-3, id2.length())+"r");
					return;
				}else if(name.length()<6){
					names.add(name);
				}
			}
			
			//1.��װ����У������
		    Cust cust = new Cust();
		    if((request.getParameter("3").contains("1"))){
				  cust.setParame1p("�ϸ�");
			  }else{
				  cust.setParame1p("���ϸ�");
				  ng++;
			  }
		    
		    //ת��plc������������
		    String value2=null;
		    if(names.contains("2")){
		    value2 = request.getParameter("2");
			  Double d = Double.valueOf(value2);
			  d = d/100;
			  d = d-1;
			  d = Math.round(d*1000)/1000.000;
			   value2 = d.toString();
			  }
			java.util.Date utilDate=new java.util.Date();
		    SimpleDateFormat dimple = new SimpleDateFormat("yyyy.MM.dd-HH.mm.ss");
		    dimple.format(utilDate); 
		    /*
		     * �жϲ�ƷID���ò�ƷID��
		     * 
		     * */
			 if(names.contains("A")&&id1!=null){
				 cust.setProductid(id1);
				 id1 = null;
			 }
			 if(names.contains("B")&&id2!=null){
				 cust.setProductid(id2);
				 id2 = null;
			 }
			  cust.setTime(utilDate);
			  cust.setPihao(pihao4);
			  cust.setXinghao(xinghao4);
			  cust.setParame1(value2);
			//���������ظ�����
			  if(cust.getProductid()==null){
				  response.getWriter().write("afffffr");
				  return;
			  }
			//�����еķ�����Ӳ�Ʒ��Ϣ
			  CustDaoImpl5 custDaoImpl5 = new CustDaoImpl5();
			  i = custDaoImpl5.addCust(cust);
			  ng =ng - i;
			//��¼��ǰ��������
			zongshu++;
			PaigongdanDaoImpl pd = new PaigongdanDaoImpl();
			pd.update4N(String.valueOf(zongshu),String.valueOf(ng));
			response.getWriter().write("afffffr");
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Paigongdan paigongdan = new Paigongdan();
		try{
		BeanUtils.populate(paigongdan, request.getParameterMap());
		xinghao4 = paigongdan.getXinghao();
		pihao4 = paigongdan.getPihao();
		zongshu = 0;
		zongshu4 = paigongdan.getZongshu();
		xingHp4 = paigongdan.getXingHp();
		Ng4 = String.valueOf(ng);
		PaigongdanDaoImpl pd = new PaigongdanDaoImpl();
		if(pd.findById()!=null){
			pd.update4(xinghao4,pihao4,zongshu4,String.valueOf(zongshu),Ng4,workerN4);
			ng = 0;
			i = 0;
		}
		response.sendRedirect(request.getContextPath()+"/index.jsp");
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}


}
