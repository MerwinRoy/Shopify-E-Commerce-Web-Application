package com.me.shopify.controller;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.captcha.botdetect.web.servlet.Captcha;
import com.me.shopify.dao.UserDAO;
import com.me.shopify.pojo.User;

@Controller
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@RequestMapping(value = "/user/login.htm", method = RequestMethod.GET)
	public String showLoginForm(HttpServletRequest request, UserDAO userDao) throws Exception {

		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");
		logger.info("Print ID!");
		if (u != null) {
			logger.info("ID..." + u.getId());
			System.out.println("ID..." + u.getId());
		}

		if (u != null && u.getName() == "admin") {

			return "admin-menu";
		} else if (u != null) {

			return "customer-dashboard";
		}

		else {
			return "user-login";
		}

	}

	@RequestMapping(value = "/user/create.htm", method = RequestMethod.GET)
	public String showCreateForm() {

		return "user-create-form";
	}


	@RequestMapping(value = "/user/create.htm", method = RequestMethod.POST)
	public String handleCreateForm(HttpServletRequest request, UserDAO userDao, ModelMap map) {
		Captcha captcha = Captcha.load(request, "CaptchaObject");
		String captchaCode = request.getParameter("captchaCode");
		HttpSession session = request.getSession();
		if (captcha.validate(captchaCode)) {
			String useremail = request.getParameter("username");
			String password = request.getParameter("password");
			User user = new User();
			user.setUserEmail(useremail);
			user.setPassword(password);
			user.setStatus(1);

			try {
				User u = userDao.register(user);
				Random rand = new Random();
				int randomNum1 = rand.nextInt(5000000);
				int randomNum2 = rand.nextInt(5000000);
				try {
					String str = "http://localhost:8080/lab11Student/user/validateemail.htm?email=" + useremail
							+ "&key1=" + randomNum1 + "&key2=" + randomNum2;
					session.setAttribute("key1", randomNum1);
					session.setAttribute("key2", randomNum2);
				} catch (Exception e) {
					System.out.println("Email cannot be sent");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			map.addAttribute("errorMessage", "Invalid Captcha!");
			return "user-create-form";
		}

		return "user-created";
	}

	@RequestMapping(value = "user/validateemail.htm", method = RequestMethod.GET)
	public String validateEmail(HttpServletRequest request, UserDAO userDao, ModelMap map) {

		// The user will be sent the following link when the use registers
		// This is the format of the email
		// http://hostname:8080/lab10/user/validateemail.htm?email=useremail&key1=<random_number>&key2=<body
		// of the email that when user registers>
		HttpSession session = request.getSession();
		String email = request.getParameter("email");
		int key1 = Integer.parseInt(request.getParameter("key1"));
		int key2 = Integer.parseInt(request.getParameter("key2"));
		System.out.println(session.getAttribute("key1"));
		System.out.println(session.getAttribute("key2"));

		if ((Integer) (session.getAttribute("key1")) == key1 && ((Integer) session.getAttribute("key2")) == key2) {
			try {
				System.out.println("HI________");
				boolean updateStatus = userDao.updateUser(email);
				if (updateStatus) {
					return "user-login";
				} else {

					return "error";
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			map.addAttribute("errorMessage", "Link expired , generate new link");
			map.addAttribute("resendLink", true);
			return "error";
		}

		return "user-login";

	}

	@RequestMapping(value = "/user/login.htm", method = RequestMethod.POST)
	public String handleLoginForm(HttpServletRequest request, UserDAO userDao, ModelMap map) {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		HttpSession session = request.getSession();

		try {
			User u = userDao.get(username, password);
			session.setAttribute("user", u);
			
			if (u != null && u.getUserEmail().equals("admin@gmail.com")){

				return "admin-menu";
			} else if (u != null && !u.getUserEmail().equals("admin@gmail.com")) {
				return "customer-dashboard";
			} else if (u != null && u.getStatus() == 1) {
				map.addAttribute("errorMessage", "Please activate your account to login!");
				return "error";
			} else {
				map.addAttribute("errorMessage", "Invalid username/password!");
				return "error";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}



	@RequestMapping(value = "/logout.htm", method = RequestMethod.GET)
	public String logoutUser(HttpServletRequest request) {

		HttpSession session = request.getSession();
		session.invalidate();

		return "logout-success";
	}

}
