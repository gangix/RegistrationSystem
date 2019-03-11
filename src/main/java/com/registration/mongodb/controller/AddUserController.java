package com.registration.mongodb.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import com.registration.mongodb.model.User;
import com.registration.mongodb.service.UserService;

@Controller
public class AddUserController {

	@Autowired
	UserService userService;

	@GetMapping(path = { "/", "/registration" })
	public ModelAndView registration() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("formName", "Registration Form");
		mav.setViewName("users");

		return mav;
	}

	@PostMapping(path = "/register")
	public ModelAndView register(@Valid User user, Errors errors) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.addObject("formName", "Registration Form");
		if (errors.hasErrors()) {
			mav.addObject("error","Invalid Entries!");
			mav.setViewName("users");

			return mav;
		}
		userService.createUser(user);
		mav.addObject("success","Added Successfully!");
		return listAll();
	}

	@GetMapping(path = "/allUser")
	public ModelAndView listAll() throws Exception {
		ModelAndView mav = new ModelAndView();
		List<User> userList = userService.listAll();
		mav.addObject("userList", userList);
		mav.setViewName("userList");
		return mav;
	}

	@GetMapping(path = "/delete/{id}")
	public ModelAndView deleteUser(@PathVariable String id) throws Exception {
		userService.deleteUser(id);
		return listAll();
	}

	@PostMapping(path = "/update")
	public ModelAndView delete(@RequestBody User user, Errors errors) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.addObject("formName", "Registration");
		if (errors.hasErrors()) {
			mav.setViewName("users");

			return mav;
		}
		userService.updateUser(user);
		return listAll();
	}
}
