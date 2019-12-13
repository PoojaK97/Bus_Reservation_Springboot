package com.javainuse.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.javainuse.model.AttributeValue;
import com.javainuse.model.Marks;
import com.javainuse.model.Student;
import com.javainuse.service.MarksService;

@Controller
public class MarkController {
	@Autowired
	MarksService markService;

	@RequestMapping("/welcomemarks")
	public ModelAndView firstPage() {
		return new ModelAndView("welcome_mark");
	}
	
	//After Bus Selection, take passenger details
	@RequestMapping(value = "/bookconfirm", method = RequestMethod.GET)
	public ModelAndView show2() {
		return new ModelAndView("boarding", "passenger", new Marks());
	}
	
	//Passenger Details for Booking
		@RequestMapping(value = "/addpassenger", method = RequestMethod.POST)
		public ModelAndView processRequest(@ModelAttribute("passenger") Marks passenger) {
			String id = markService.insertMark(passenger);
			ModelAndView model = new ModelAndView("confirmation");
			model.addObject("id", id);
			return model;
		}
	
	//To get booking id for booking details
	@RequestMapping(value = "/checkreservation", method = RequestMethod.GET)
	public ModelAndView show6() {
		return new ModelAndView("check", "booking", new Marks());
	}
	
	//Search the database to get booking details
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ModelAndView processRequest1(@ModelAttribute("booking") Marks passenger) {
		Marks p = markService.getMarks(passenger);
		if (p.getId()!=null) {
			ModelAndView model = new ModelAndView("Details");
			model.addObject("passenger", p);
			return model;
		}
		else {
			ModelAndView model = new ModelAndView("nores");
			return model;
		}
	}
	
	//To cancel with booking id, Booking ID to be received
	@RequestMapping(value = "/cancelconfirmation", method = RequestMethod.POST)
	public ModelAndView processRequest5(@ModelAttribute("id") String id) {
		//Search based on id
		markService.delete(id);
		return new ModelAndView("CancelConfirmation", "id", id);
	}
	
	//To update details of passenger
	@RequestMapping(value = "/updatedetails", method = RequestMethod.POST)
	public ModelAndView processRequest4(@ModelAttribute("id") String id) {
		Marks s = markService.search(id);
		return new ModelAndView("update", "stud", s);
	}
	
	@RequestMapping(value = "/editdetails", method = RequestMethod.POST)
	public ModelAndView processRequest2(@ModelAttribute("stud") Marks stud) {
		
		markService.edit(stud);
		ModelAndView model = new ModelAndView("Details");
		model.addObject("passenger", stud);
		return model;
	}
}
