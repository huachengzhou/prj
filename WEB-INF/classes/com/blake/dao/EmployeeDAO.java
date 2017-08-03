package com.blake.dao;

import java.util.List;

import com.blake.bean.Employee;
/**
 * @see 员工Dao
 * @author Blake.Zhou
 *
 */
public interface EmployeeDAO {
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
}
