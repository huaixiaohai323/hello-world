package com.itheima.service;

import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import com.itheima.dao.CustDao;
import com.itheima.dao.CustDaoImpl;
import com.itheima.domain.Cust;
import com.itheima.domain.Page;
import com.itheima.util.DaoUtils;


public class CustServiceImpl implements CustService {
//	CustDao dao = BasicFactory.getFactory().getInstance(CustDao.class);
	CustDao dao = new CustDaoImpl();
	public int addCust(Cust cust) {
		//1.����û����Ƿ��Ѿ�����
		Cust cunzai = dao.findUserByProductid(cust.getProductid());
		if(cunzai!=null){
			dao.updateCust(cust);
			if(cunzai.getParame1p().equals("�ϸ�")){
				return 0;
			}
			return 1;
		}else{
		dao.addCust(cust);
		return 0;
		}
	}
	public List<Cust> getAllCust() {
		return dao.getAllCust();
	}
	public Cust findCustById(String id) {
		return dao.findUserById(id);
	}
	public void updateCust(Cust cust) {
		dao.updateCust(cust);
	}
	public void delCustByID(String id) {
		dao.delCustByID(id);
	}
	public void batchDel(String[] ids) {
		Connection conn = DaoUtils.getConn();
		try{
			conn.setAutoCommit(false);
			for(String id : ids){
				dao.delCustByIDWithTrans(conn,id);
			}
			DbUtils.commitAndCloseQuietly(conn);
		}catch (Exception e) {
			DbUtils.rollbackAndCloseQuietly(conn);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	public List<Cust> findCustByCond(Cust cust) {
		return dao.findCustByCond(cust);
	}
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
	public Cust findUserByProductid(String productid) {
		return dao.findUserByProductid(productid);
	}
}
