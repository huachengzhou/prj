package com.blake.service;

import java.util.List;


import com.blake.bean.Criticism;
import com.blake.bean.Employee;
import com.blake.bean.Message;
import com.blake.bean.Reply;
import com.blake.util.Page;
/**
 * 业务层
 * @author Blake.Zhou
 *
 */
public interface PrjService {
	/**
	 * @see 添加批复
	 * @param criticism
	 */
	public void addCriticism(Criticism criticism);

	/**
	 * @see 按文章ID查找批复
	 * @param messageID
	 * @return
	 */
	public Criticism findCriticismByMsgID(int messageID);

	/* .............................................. */
	/**
	 * @see 添加员工信息的方法
	 * @param employee
	 */
	public void addEmployee(Employee employee);

	/**
	 * @see 修改员工信息的方法
	 * @param employee
	 */
	public void updateEmployee(Employee employee);

	/**
	 * @see 删除员工信息的方法
	 * @param employeeID
	 */
	public void deleteEmployee(int employeeID);

	/**
	 * @see 查询所有员工信息的方法
	 * @return
	 */
	public List<Employee> findAllEmployee();

	/**
	 * @see 按ID查询员工信息的方法
	 * @param employeeID
	 * @return
	 */
	public Employee findEmployeeById(int employeeID);

	/* .............................................. */
	/**
	 * @see 添加消息的方法
	 * @param message
	 */
	public void addMessage(Message message);

	/**
	 * @see 修改消息的方法
	 * @param message
	 */
	public void updateMessage(Message message);

	/**
	 * @see 删除消息的方法
	 * @param messageID
	 */
	public void deleteMessage(int messageID);

	/**
	 * @see 按分页信息查询所有消息的方法
	 * @param page
	 * @return
	 */
	public List<Message> findAllMessagee(Page page);

	/**
	 * @see 按ID查询消息的方法
	 * @param messageID
	 * @return
	 */
	public Message findMessageById(int messageID);

	/**
	 * @see 查询消息记录数
	 * @return
	 */
	public int findAllCount();

	/* .............................................. */
	/**
	 * @see 添加回复
	 * @param replay
	 */
	public void addReplay(Reply reply);

	/**
	 * @see 按文章ID查找回复
	 * @param messageID
	 * @param page
	 * @return
	 */
	public List<Reply> findReplayByMsgID(int messageID, Page page);// 传入hashMap

	/**
	 * @see 查询消息回复记录数
	 * @param messageID
	 * @return
	 */
	public int findCountByMsgID(int messageID);
	/* .............................................. */
}
