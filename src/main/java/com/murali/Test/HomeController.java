package com.murali.Test;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.murali.Test.ServiceLayer.TestService;
import com.murali.Test.dto.Student;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	Student studentSaved=null;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private TestService testService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	@RequestMapping(value = "/StudentSaveForm", method = {RequestMethod.GET,RequestMethod.POST})
	public String studentSaveForm(Locale locale, Model model) {
		logger.info("********************************** saveform");
		model.addAttribute("student", new Student() );
		return "student";
	}
	@RequestMapping(value = "/StudentSave", method = RequestMethod.POST)
	public String studentSave(@ModelAttribute("student") Student student, Locale locale, Model model) {
		logger.info(student+"");
		studentSaved=student;
		logger.info("**********************************################## student save");
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		testService.saveStudent(student);
		return "home";
	}
	
	@RequestMapping(value = "/StudentupdateFormField", method = {RequestMethod.GET,RequestMethod.POST})
	public String updateStudentField(Locale locale, Model model,HttpServletRequest httpServletRequest) {
		logger.info("**********************************################ update form field");
		return "updateField";
	}
	@RequestMapping(value = "/StudentUpdateForm", method = RequestMethod.POST)
	public String updateStudentForm(Locale locale, Model model,HttpServletRequest httpServletRequest) {
		System.out.println(httpServletRequest.getParameter("id"));
		Integer id=new Integer(httpServletRequest.getParameter("id"));
		Student student = testService.getStudent(id);
		logger.info(student+":::");
		model.addAttribute("student", student);
		logger.info("**********************************################## update student Form");
		return "student";
	}
	@RequestMapping(value = "/StudentUpdate", method = RequestMethod.POST)
	public String updateStudent(@ModelAttribute("student") Student student, Locale locale, Model model) {
		logger.info(student+"");
		logger.info("**********************************################## update student");
		testService.updateStudent(student);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		return "home";
	}
	
	@RequestMapping(value = "/StudentDeleteFormField", method = {RequestMethod.GET,RequestMethod.POST})
	public String deleteStudentField(Locale locale, Model model,HttpServletRequest httpServletRequest) {
		logger.info("**********************************################## delete field");
		return "deleteField";
	}
	@RequestMapping(value = "/StudentDelete", method = {RequestMethod.GET,RequestMethod.POST})
	public String deleteStudent(Locale locale, Model model,HttpServletRequest httpServletRequest) {
		logger.info("**********************************################## delete student");
		Integer id=new Integer(httpServletRequest.getParameter("id"));
		testService.deleteStudent(id);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		studentSaved=null;
		model.addAttribute("serverTime", formattedDate );
		return "home";
	}
	@RequestMapping(value = "/FindStudents", method = {RequestMethod.GET,RequestMethod.POST})
	public String findStudent(Locale locale, Model model,HttpServletRequest httpServletRequest) {
		List<Student> list=testService.findStudents();
		model.addAttribute("list", list);
		return "students";
	}
	
	
}
