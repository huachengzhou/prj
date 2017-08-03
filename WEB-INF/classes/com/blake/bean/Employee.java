package com.blake.bean;

import java.io.Serializable;
import java.util.Date;

import com.sun.istack.internal.NotNull;
/**
 * @see Ա��
 * @author Blake.Zhou
 *
 */
@SuppressWarnings("serial")
public class Employee implements Serializable {
	private int employeeID;			//Ա�����
	@NotNull
	private String employeeName;	//Ա������
	private boolean employeeSex;	//Ա���Ա�
	private Date employeeBirth;		//��������
	@NotNull
	private String employeePhone;	//�칫�ҵ绰
	@NotNull
	private String employeePlace;	//סַ
	private Date joinTime;			//¼��ʱ��
	@NotNull
	private String password;		//ϵͳ����
	private boolean isLead;			//�Ƿ�Ϊ������쵼
	
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public boolean isEmployeeSex() {
		return employeeSex;
	}
	public void setEmployeeSex(boolean employeeSex) {
		this.employeeSex = employeeSex;
	}
	public Date getEmployeeBirth() {
		return employeeBirth;
	}
	public void setEmployeeBirth(Date employeeBirth) {
		this.employeeBirth = employeeBirth;
	}
	public String getEmployeePhone() {
		return employeePhone;
	}
	public void setEmployeePhone(String employeePhone) {
		this.employeePhone = employeePhone;
	}
	public String getEmployeePlace() {
		return employeePlace;
	}
	public void setEmployeePlace(String employeePlace) {
		this.employeePlace = employeePlace;
	}
	public Date getJoinTime() {
		return joinTime;
	}
	public void setJoinTime(Date joinTime) {
		this.joinTime = joinTime;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Employee(String employeeName, boolean employeeSex, Date employeeBirth, String employeePhone,
			String employeePlace, Date joinTime, String password, boolean isLead) {
		this.employeeName = employeeName;
		this.employeeSex = employeeSex;
		this.employeeBirth = employeeBirth;
		this.employeePhone = employeePhone;
		this.employeePlace = employeePlace;
		this.joinTime = joinTime;
		this.password = password;
		this.isLead = isLead;
	}
	public Employee() {
	}
//	public boolean isLead() {
//		return isLead;
//	}
	public void setLead(boolean isLead) {
		this.isLead = isLead;
	}
	public boolean getLead(){
		return isLead;
	}
	@Override
	public String toString() {
		return "Employee [employeeID=" + employeeID + ", employeeName=" + employeeName + ", employeeSex=" + employeeSex
				+ ", employeeBirth=" + employeeBirth + ", employeePhone=" + employeePhone + ", employeePlace="
				+ employeePlace + ", joinTime=" + joinTime + ", password=" + password + ", isLead=" + isLead + "]";
	}
}
