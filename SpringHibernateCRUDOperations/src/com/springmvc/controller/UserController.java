package com.springmvc.controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.dao.UserDAO;
import com.springmvc.dao.UserDAOImpl;
import com.springmvc.model.User;

@Controller
public class UserController {


	UserDAO dao=new UserDAOImpl();
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView user() {
		System.out.println("In Controller");
		
		return new ModelAndView("index", "command", new User());
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public ModelAndView addEmployee(@ModelAttribute("user") User user, ModelMap model) {

		dao.addUser(user);
		ModelAndView mv = new ModelAndView("redirect:/getAllUsers");
		return mv;
	}
	
	@RequestMapping(value="/getAllUsers")
	public ModelAndView getAllUsers()
	{
		
		List<User> user_list=dao.getAllUsers();
		for(User u:user_list)
		{
			System.out.println("ID: "+u.getId()+" Name: "+u.getName()+" Age: "+u.getAge());
		}
		ModelAndView mv=new ModelAndView("listOfAll");
		mv.addObject("user_list",user_list);
		return mv;
	}
	
	@RequestMapping("/deleteUserByID")
	public ModelAndView deleteUser(
		@RequestParam(value = "id", required = false, defaultValue = "World") int id) {
		System.out.println("in delete controller");
		dao.deleteUser(id);
		ModelAndView mv = new ModelAndView("redirect:/getAllUsers");
		return mv;
	}
	
	@RequestMapping(value="/updateUserByID",method = RequestMethod.GET)
	public ModelAndView updateUser(
		@RequestParam(value = "id", required = false, defaultValue = "World") int id) {
		System.out.println("in update controller");
		
		ModelAndView mv=new ModelAndView("edit", "command", new User());
		mv.addObject("editId",id);
		return mv;
	}
	
	@RequestMapping(value="/update",method = RequestMethod.POST)
	public ModelAndView update(@RequestParam(value = "id", required = false, defaultValue = "World") int id,@ModelAttribute("user") User user) {
		System.out.println("in edit controller");
		
		dao.updateUser(id,user);
		
		ModelAndView mv = new ModelAndView("redirect:/getAllUsers");
		return mv;
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView userNew() {
		
		ModelAndView mv = new ModelAndView("redirect:/");
		return mv;
	}
	
}
