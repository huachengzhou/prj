package com.blake.dao;

import java.util.List;

import com.blake.bean.Employee;
/**
 * @see Ա��Dao
 * @author Blake.Zhou
 *
 */
public interface EmployeeDAO {
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
}
