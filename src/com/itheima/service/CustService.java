package com.itheima.service;

import java.util.List;

import com.itheima.domain.Cust;
import com.itheima.domain.Page;

public interface CustService {

	/**
	 * ��ӿͻ�
	 * @param cust ��װ���û���Ϣ��bean
	 * @return 
	 */
	int addCust(Cust cust);

	/**
	 * ��ѯ���пͻ���Ϣ
	 * @return
	 */
	List<Cust> getAllCust();

	/**
	 * ����id���ҿͻ���Ϣ
	 * @param id �ͻ�id
	 * @return ���ҵ��Ŀͻ���Ϣ,����Ҳ�������null
	 */
	Cust findCustById(String id);
	
	Cust findUserByProductid(String productid);

	/**
	 * �޸Ŀͻ���Ϣ�ķ���
	 * @param cust ��װ�����¿ͻ���Ϣ��bean
	 */
	void updateCust(Cust cust);

	/**
	 * ����idɾ���ͻ�
	 * @param id
	 */
	void delCustByID(String id);

	/**
	 * �����˴��ͻ� ���л�����������
	 * @param ids ����Ҫɾ����id��ɵ�����
	 */
	void batchDel(String[] ids);

	/**
	 * ����������ѯ�ͻ���Ϣ
	 * @param cust ��װ�˲�ѯ������bean,���п������û���/�Ա�/�ͻ�����
	 * @return ���������Ŀͻ���ɵļ���
	 */
	List<Cust> findCustByCond(Cust cust);

	/**
	 * ��ҳ��ѯ�ͻ��ķ���
	 * @param thispage ��ǰҳ��
	 * @param rowperpage ÿҳ��¼��
	 * @return ��ǰҳ������Ϣ
	 */
	Page pageCust(int thispage, int rowperpage);

}
