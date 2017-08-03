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
     * 添加事务注解,并且为事务指定传播行为
     * 当前的事务方法被另外一个事务方法调用时,如何使用事务,默认取值为:REQUIRED----------(使用调用方法的事务)
     * 或者开启一个新事务(使用必须得小心)REQUIRES_NEW:使用自己的事务,调用事务的方法的事务被挂起
     * 事务的隔离级别:READ_COMMITTED--------(通常选这个)
     * 默认情况下Spring的声明式事务对所有的异常进行回滚,noRollbackFor设置不用回滚的事务
     * readOnly数据库是否只读:这可以帮助数据库进行优化,但是用的时候必须小心
     * 使用timeout指定强制回滚之前事务可以占有的时间
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
