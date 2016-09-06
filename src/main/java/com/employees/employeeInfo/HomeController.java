package com.employees.employeeInfo;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.employees.employeeInfo.dao.EmployeeDao;
import com.employees.employeeInfo.dao.UserDao;
import com.employees.employeeInfo.model.User;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired
	UserDao userDao;

	@Autowired
	EmployeeDao employeeDao;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {

		return "login";
	}

	@RequestMapping(value = "/employeeInfo", method = RequestMethod.GET)
	public String profileGET(@ModelAttribute User user, Model model, HttpSession session) {
		model.addAttribute("pageCount", employeeDao.pageCount());
		model.addAttribute("employeeList", employeeDao.getAll());

		return "employeeInfo";
	}

	@RequestMapping(value = "/employeeInfo", method = RequestMethod.POST)
	public String profilePOST(@ModelAttribute User user, Model model, HttpSession session) {

		if (userDao.validateUser(user)) {
			session.setAttribute("activeUser", user.getUserName());
			session.setMaxInactiveInterval(10 * 60);
			model.addAttribute("employeeList", employeeDao.getAll());
			model.addAttribute("pageCount", employeeDao.pageCount());

			return "employeeInfo";
		} else {
			model.addAttribute("loginError", "error in username/ password:");
			return "login";
		}

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:/login";
	}

	@RequestMapping(value = "{id}/delete", method = RequestMethod.GET)
	public String deleteemployee(Model model, @PathVariable("id") Long id) {
		// Delete record.
		employeeDao.delete(id);
		return "redirect:/employeeInfo";
	}

	@RequestMapping(value = "/listemployee", method = RequestMethod.GET)
	public String offsetCheck(Model model, @RequestParam("offset") String offset) {
		model.addAttribute("employeeList", employeeDao.getSelected(Integer.parseInt(offset)));
		model.addAttribute("pageCount", employeeDao.pageCount());
		return "employeeInfo";
	}
}