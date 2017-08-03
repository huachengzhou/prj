package com.blake.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * @see 回复消息 Bean
 * @author Blake.Zhou
 *
 */
@SuppressWarnings("serial")
public class Reply implements Serializable {
	private int replyID; // 回复ID
	private String replyContent;// 回复内容
	private int employeeID; // 回复人ID
	private Date replyTime; // 回复时间
	private int messageID;//消息ID
	/**
	 * 消息
	 */
	private Message message;
	/**
	 * 回复人
	 */
	private Employee employee;
	public Reply() {
	}
	public Reply(int replyID, String replyContent, Date replyTime, Message message, Employee employee) {
		super();
		this.replyID = replyID;
		this.replyContent = replyContent;
		this.replyTime = replyTime;
		this.message = message;
		this.employee = employee;
	}
	public int getReplyID() {
		return replyID;
	}
	public void setReplyID(int replyID) {
		this.replyID = replyID;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	public Date getReplyTime() {
		return replyTime;
	}
	public void setReplyTime(Date replyTime) {
		this.replyTime = replyTime;
	}
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public int getMessageID() {
		return messageID;
	}
	public void setMessageID(int messageID) {
		this.messageID = messageID;
	}
	@Override
	public String toString() {
		return "Reply [replyID=" + replyID + ", replyContent=" + replyContent + ", employeeID=" + employeeID
				+ ", replyTime=" + replyTime + ", messageID=" + messageID + ", message=" + message + ", employee="
				+ employee + "]";
	}
	
}
