package com.blake.bean;

import java.io.Serializable;
import java.util.Date;
/**
 * @see 批复Bean
 * @author Blake.Zhou
 *
 */
@SuppressWarnings("serial")
public class Criticism implements Serializable {
	private int criticismID;		//批复ID
	private String criticismContent;//批复内容
	private int employeeID;			//批复人ID
	private Date criticismTime;		//批复时间
	private int messageID;			//消息ID
	
	private Message message;
	private Employee employee;
	public int getCriticismID() {
		return criticismID;
	}
	public void setCriticismID(int criticismID) {
		this.criticismID = criticismID;
	}
	public String getCriticismContent() {
		return criticismContent;
	}
	public void setCriticismContent(String criticismContent) {
		this.criticismContent = criticismContent;
	}
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
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
	public Date getCriticismTime() {
		return criticismTime;
	}
	public void setCriticismTime(Date criticismTime) {
		this.criticismTime = criticismTime;
	}
	public int getMessageID() {
		return messageID;
	}
	public void setMessageID(int messageID) {
		this.messageID = messageID;
	}
	public Criticism(String criticismContent, Date criticismTime, Message message, Employee employee) {
		this.criticismContent = criticismContent;
		this.criticismTime = criticismTime;
		this.message = message;
		this.employee = employee;
	}
	public Criticism(String criticismContent, Date criticismTime) {
		this.criticismContent = criticismContent;
		this.criticismTime = criticismTime;
	}
	public Criticism() {
	}
	@Override
	public String toString() {
		return "Criticism [criticismID=" + criticismID + ", criticismContent=" + criticismContent + ", employeeID="
				+ employeeID + ", criticismTime=" + criticismTime + ", messageID=" + messageID + ", message=" + message
				+ ", employee=" + employee + "]";
	}
}
