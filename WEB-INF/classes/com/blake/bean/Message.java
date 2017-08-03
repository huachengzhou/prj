package com.blake.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * @see ��Ϣ
 * @author Blake.Zhou
 *
 */
@SuppressWarnings("serial")
public class Message implements Serializable {
	private int messageID; // ��ϢID
	private String messageTitle; // ��Ϣ����
	private String messageContent; // ��Ϣ����
	private int employeeID; // ������ID
	private Date publishTime; // ����ʱ��

	private Employee employee;

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

	public String getMessageTitle() {
		return messageTitle;
	}

	public void setMessageTitle(String messageTitle) {
		this.messageTitle = messageTitle;
	}

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public Date getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	public Message() {
	}

	public Message(String messageTitle, String messageContent, Date publishTime, Employee employee) {
		this.messageTitle = messageTitle;
		this.messageContent = messageContent;
		this.publishTime = publishTime;
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Message [messageID=" + messageID + ", messageTitle=" + messageTitle + ", messageContent="
				+ messageContent + ", employeeID=" + employeeID + ", publishTime=" + publishTime + ", employee="
				+ employee + "]";
	}


}
