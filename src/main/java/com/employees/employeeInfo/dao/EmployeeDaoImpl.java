package com.employees.employeeInfo.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.employees.employeeInfo.model.Employee;


@Repository
public class EmployeeDaoImpl implements EmployeeDao{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public void insertUpdate(Employee employee) {

		
		entityManager.merge(employee);
		
		
	}

	@Override
	public Employee get(Long id) {
		// TODO Auto-generated method stub
//		Session session = sessionFactory.getCurrentSession();
//		Employee employee = (Employee) session.get(Employee.class, id);
//		session.close();
		
		Employee employee= entityManager.find(Employee.class, id);
	
		return employee;
	}

	@Override
	@Transactional
	public List<Employee> getAll() {
		Query query =  entityManager.createQuery("SELECT e FROM Employee e", Employee.class);
		query.setFirstResult(0);
		query.setMaxResults(10);
				 List<Employee> employeeList = query.getResultList();
				 return employeeList;
	}

	@Override
	@Transactional
	public void delete(Long id) {
		Employee employee= entityManager.find(Employee.class, id);
		entityManager.remove(employee);	
	}
	
public Long pageCount() {
	CriteriaBuilder cb = entityManager.getCriteriaBuilder();
	CriteriaQuery<Long> cq = cb.createQuery(Long.class);
	cq.select(cb.count(cq.from(Employee.class)));
	Long count= (( entityManager.createQuery(cq).getSingleResult()/10)+1);
	System.out.println(count);
		return count;	
	}

@Override
public List<Employee> getSelected(int offset) {
	Query query = entityManager.createQuery("SELECT e from Employee e ");
	query.setFirstResult(offset);
	query.setMaxResults(10);
	
	List<Employee> employee= (List<Employee>)query.getResultList();
	
	return employee;
}

}
