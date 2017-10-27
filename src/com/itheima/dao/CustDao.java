package com.itheima.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.itheima.domain.Cust;

public interface CustDao {

	/**
	 * �����û��������û�
	 * @param name �û���
	 * @return �ҵ����û�,����Ҳ�������null
	 */
	Cust findUserByProductid(String name);

	/**
	 * ��ӿͻ�
	 * @param cust
	 */
	void addCust(Cust cust);

	/**
	 * ��ѯ���пͻ���Ϣ��ɵļ���
	 * @return ��װ�����пͻ���Ϣ�ļ���,���û���κοͻ�,���صļ���������Ϊ��
	 */
	List<Cust> getAllCust();

	/**
	 * ����id���ҿͻ�
	 * @param id �ͻ�id
	 * @return �ͻ�bean
	 */
	Cust findUserById(String id);

	/**
	 * �޸Ŀͻ���Ϣ
	 * @param cust ������Ϣbean
	 */
	void updateCust(Cust cust);

	/**
	 * ����idɾ���ͻ�
	 * @param id
	 */
	void delCustByID(String id);

	/**
	 * ����Idɾ���ͻ�,����������
	 * @param id
	 * @throws SQLException 
	 */
	void delCustByIDWithTrans(Connection conn, String id) throws SQLException;

	/**
	 * �����û���/�Ա�/�ͻ����Ͳ��ҿͻ�
	 * @param cust
	 * @return
	 */
	List<Cust> findCustByCond(Cust cust);

	/**
	 * ��ѯ���ݿ���һ���ж�������¼
	 * @return
	 */
	int getCountRow();

	/**
	 * ��ѯָ����¼���������¼
	 * @param from ��������¼��ȡ
	 * @param count ȡ������
	 * @return
	 */
	List<Cust> getCustByPage(int from, int count);

}
