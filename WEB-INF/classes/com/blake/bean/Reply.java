package com.blake.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * @see �ظ���Ϣ Bean
 * @author Blake.Zhou
 *
 */
@SuppressWarnings("serial")
public class Reply implements Serializable {
	private int replyID; // �ظ�ID
	private String replyContent;// �ظ�����
	private int employeeID; // �ظ���ID
	private Date replyTime; // �ظ�ʱ��
	private int messageID;//��ϢID
	/**
	 * ��Ϣ
	 */
	private Message message;
	/**
	 * �ظ���
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
