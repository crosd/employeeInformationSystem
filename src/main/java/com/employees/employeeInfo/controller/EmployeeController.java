package com.employees.employeeInfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.employees.employeeInfo.dao.EmployeeDao;
import com.employees.employeeInfo.model.Employee;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {
	@Autowired
	EmployeeDao employeeDao;

	@RequestMapping(method = RequestMethod.GET)
	public String employeeGET(Model model) {
		model.addAttribute("employee", new Employee());
		return "employeeForm";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String employeePOST(Model model, @ModelAttribute Employee employee) {
		System.out.println(employee.getFirstName());
		employeeDao.insertUpdate(employee);
		model.addAttribute("pageCount", employeeDao.pageCount());
		model.addAttribute("employeeList", employeeDao.getAll());
		return "employeeInfo";
	}

	@RequestMapping(value = "{id}/edit", method = RequestMethod.GET)
	public String editemployee(Model model, @PathVariable("id") Long id) {
		// Show employee DB Record for that id.
		model.addAttribute("employee", employeeDao.get(id));
		return "employeeForm";
	}

	@RequestMapping(value = "{id}/edit", method = RequestMethod.POST)
	public String editemployeePOST(Model model, @ModelAttribute Employee employee) {
		employeeDao.insertUpdate(employee);
		return "redirect:/employeeInfo";
	}

}
