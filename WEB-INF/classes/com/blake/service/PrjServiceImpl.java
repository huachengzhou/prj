package com.blake.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.blake.bean.Criticism;
import com.blake.bean.Employee;
import com.blake.bean.Message;
import com.blake.bean.Reply;
import com.blake.dao.CriticismDAO;
import com.blake.dao.EmployeeDAO;
import com.blake.dao.MessageDAO;
import com.blake.dao.ReplyDAO;
import com.blake.util.Page;

@Service(value="prjService")
public class PrjServiceImpl implements PrjService {
	@Autowired
	private CriticismDAO criticismDao;
	@Autowired
	private EmployeeDAO employeeDao;
	@Autowired
	private MessageDAO messageDao;
	@Autowired
	private ReplyDAO replyDao;
	 /**
     * �������ע��,����Ϊ����ָ��������Ϊ
     * ��ǰ�����񷽷�������һ�����񷽷�����ʱ,���ʹ������,Ĭ��ȡֵΪ:REQUIRED----------(ʹ�õ��÷���������)
     * ���߿���һ��������(ʹ�ñ����С��)REQUIRES_NEW:ʹ���Լ�������,��������ķ��������񱻹���
     * ����ĸ��뼶��:READ_COMMITTED--------(ͨ��ѡ���)
     * Ĭ�������Spring������ʽ��������е��쳣���лع�,noRollbackFor���ò��ûع�������
     * readOnly���ݿ��Ƿ�ֻ��:����԰������ݿ�����Ż�,�����õ�ʱ�����С��
     * ʹ��timeoutָ��ǿ�ƻع�֮ǰ�������ռ�е�ʱ��
     */
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED)
	public void addCriticism(Criticism criticism) {
		criticismDao.addCriticism(criticism);
	}

	public Criticism findCriticismByMsgID(int messageID) {
		return criticismDao.findCriticismByMsgID(messageID);
	}

	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED)
	public void addEmployee(Employee employee) {
		employeeDao.addEmployee(employee);
	}

	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED)
	public void updateEmployee(Employee employee) {
		employeeDao.updateEmployee(employee);
	}

	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED)
	public void deleteEmployee(int employeeID) {
		employeeDao.deleteEmployee(employeeID);
	}

	@Override
	public List<Employee> findAllEmployee() {
		return employeeDao.findAllEmployee();
	}

	@Override
	public Employee findEmployeeById(int employeeID) {
		return employeeDao.findEmployeeById(employeeID);
	}

	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED)
	public void addMessage(Message message) {
		messageDao.addMessage(message);
	}

	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED)
	public void updateMessage(Message message) {
		messageDao.updateMessage(message);
	}

	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED)
	public void deleteMessage(int messageID) {
		messageDao.deleteMessage(messageID);
	}

	@Override
	public List<Message> findAllMessagee(Page page) {
		return messageDao.findAllMessagee(page);
	}

	@Override
	public Message findMessageById(int messageID) {
		return messageDao.findMessageById(messageID);
	}

	@Override
	public int findAllCount() {
		return messageDao.findAllCount();
	}

	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED)
	public void addReplay(Reply replay) {
		replyDao.addReplay(replay);
	}

	@Override
	public List<Reply> findReplayByMsgID(int messageID, Page page) {
		HashMap<String,Object> hashmap = new HashMap<String,Object>();
		Message message = messageDao.findMessageById(messageID);
		hashmap.put("message",message);
		hashmap.put("page",page);
		return replyDao.findReplayByMsgID(hashmap);
	}

	@Override
	public int findCountByMsgID(int messageID) {
		Message message = messageDao.findMessageById(messageID);
		return replyDao.findCountByMsgID(message);
	}

}
