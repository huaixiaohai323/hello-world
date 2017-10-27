package com.itheima.service;

import java.util.List;

import com.itheima.dao.CustDaoImpl0;
import com.itheima.domain.Cust;
import com.itheima.domain.Page;


public class CustServiceImpl0 {
//	CustDao dao = BasicFactory.getFactory().getInstance(CustDao.class);
	CustDaoImpl0 dao = new CustDaoImpl0();
	public Page pageCust(int thispage, int rowperpage) {
		Page page = new Page();
		//--��ǰҳ
		page.setThispage(thispage);
		//--ÿҳ��¼��
		page.setRowperpage(rowperpage);
		//--���ж�����
		int countrow = dao.getCountRow();
		page.setCountrow(countrow);
		//--���ж���ҳ
		int countpage = countrow/rowperpage+(countrow%rowperpage==0?0:1);
		page.setCountpage(countpage);
		//--��ҳ
		page.setFirstpage(1);
		//--βҳ
		page.setLastpage(countpage);
		//--��һҳ
		page.setPrepage(thispage==1?1:thispage-1);
		//--��һҳ
		page.setNextpage(thispage == countpage ? countpage : thispage+1);
		//--��ǰҳ����
		List<Cust> list = dao.getCustByPage((thispage-1)*rowperpage,rowperpage);
		page.setList(list);
		
		return page;
	}
}
