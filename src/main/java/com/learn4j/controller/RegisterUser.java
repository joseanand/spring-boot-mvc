/**
 * 
 */
package com.learn4j.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.learn4j.models.User;
import com.learn4j.service.CustomUserDetailsService;

/**
 * @author jose
 *
 */
@Controller
public class RegisterUser {
	
	@Autowired
	private CustomUserDetailsService userService;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView signup() {
	    ModelAndView modelAndView = new ModelAndView();
	    User user = new User();
	    modelAndView.addObject("user", user);
	    modelAndView.setViewName("register");
	    return modelAndView;
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
		ModelAndView mv = new ModelAndView();
		User userExists = userService.findUserByEmail(user.getEmail());
		if(userExists != null) {
			bindingResult
            .rejectValue("email", "error.user",
                    "There is already a user registered with the username provided");
		}
		if(bindingResult.hasErrors()) {
			mv.setViewName("register");
		}else {
			userService.saveUser(user);
			mv.addObject("successMessage", "User has been registered successfully");
	        mv.addObject("user", new User());
	        mv.setViewName("login");
		}
		return mv;
	}
	
}
