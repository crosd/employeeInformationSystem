package com.employees.employeeInfo.dao;

import java.util.List;

import com.employees.employeeInfo.model.Employee;

public interface EmployeeDao {
	public void insertUpdate(Employee employee);
	public Employee get(Long id);
	public List<Employee> getAll();
	public void delete(Long id);
	public Long pageCount();
	public List<Employee> getSelected(int offset);
}
