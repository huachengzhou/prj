package com.blake.service;

import java.util.List;


import com.blake.bean.Criticism;
import com.blake.bean.Employee;
import com.blake.bean.Message;
import com.blake.bean.Reply;
import com.blake.util.Page;
/**
 * ҵ���
 * @author Blake.Zhou
 *
 */
public interface PrjService {
	/**
	 * @see �������
	 * @param criticism
	 */
	public void addCriticism(Criticism criticism);

	/**
	 * @see ������ID��������
	 * @param messageID
	 * @return
	 */
	public Criticism findCriticismByMsgID(int messageID);

	/* .............................................. */
	/**
	 * @see ���Ա����Ϣ�ķ���
	 * @param employee
	 */
	public void addEmployee(Employee employee);

	/**
	 * @see �޸�Ա����Ϣ�ķ���
	 * @param employee
	 */
	public void updateEmployee(Employee employee);

	/**
	 * @see ɾ��Ա����Ϣ�ķ���
	 * @param employeeID
	 */
	public void deleteEmployee(int employeeID);

	/**
	 * @see ��ѯ����Ա����Ϣ�ķ���
	 * @return
	 */
	public List<Employee> findAllEmployee();

	/**
	 * @see ��ID��ѯԱ����Ϣ�ķ���
	 * @param employeeID
	 * @return
	 */
	public Employee findEmployeeById(int employeeID);

	/* .............................................. */
	/**
	 * @see �����Ϣ�ķ���
	 * @param message
	 */
	public void addMessage(Message message);

	/**
	 * @see �޸���Ϣ�ķ���
	 * @param message
	 */
	public void updateMessage(Message message);

	/**
	 * @see ɾ����Ϣ�ķ���
	 * @param messageID
	 */
	public void deleteMessage(int messageID);

	/**
	 * @see ����ҳ��Ϣ��ѯ������Ϣ�ķ���
	 * @param page
	 * @return
	 */
	public List<Message> findAllMessagee(Page page);

	/**
	 * @see ��ID��ѯ��Ϣ�ķ���
	 * @param messageID
	 * @return
	 */
	public Message findMessageById(int messageID);

	/**
	 * @see ��ѯ��Ϣ��¼��
	 * @return
	 */
	public int findAllCount();

	/* .............................................. */
	/**
	 * @see ��ӻظ�
	 * @param replay
	 */
	public void addReplay(Reply reply);

	/**
	 * @see ������ID���һظ�
	 * @param messageID
	 * @param page
	 * @return
	 */
	public List<Reply> findReplayByMsgID(int messageID, Page page);// ����hashMap

	/**
	 * @see ��ѯ��Ϣ�ظ���¼��
	 * @param messageID
	 * @return
	 */
	public int findCountByMsgID(int messageID);
	/* .............................................. */
}
