package com.employees.employeeInfo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.employees.employeeInfo.model.User;

@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
	DataSource dataSource;
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public boolean validateUser(User user) {
	
		Query query = entityManager.createNativeQuery("SELECT u.user_name from User u where u.user_name=? and u.password=? ");
		
		query.setParameter(1, user.getUserName());
		query.setParameter(2, user.getPassword());
	
		List<String> dbUser= query.getResultList();
		System.out.println(dbUser);
		if(dbUser.isEmpty()){
			return false;
		}else
			return true;			
	}	
}
