package com.cognizant.controller;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Registration;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.entity.Admin;
import com.cognizant.entity.Login;
import com.cognizant.entity.Patient;
import com.cognizant.entity.Physician;
import com.cognizant.service.AdminService;
import com.cognizant.service.LoginService;
import com.cognizant.service.PatientService;
import com.cognizant.service.PhysicianService;
import com.cognizant.validation.LoginValidator;

//import sun.rmi.runtime.Log;

@Controller
@SessionAttributes({"updatePatient","updatePhysician"})
public class AdminController {
	
	@Autowired
	private LoginService loginService;
	@Autowired
	private AdminService adminService;
	@Autowired@Qualifier(value="LoginValidator")
    private Validator loginValidator;
    @Autowired
    private PatientService patientService;
    @Autowired
    private PhysicianService physicianService;
    @Autowired@Qualifier(value="RegistrationValidator")
    private Validator registrationValidator;
    @Autowired
    private Admin admin;
    
    @ModelAttribute("login")
	public Login createAdminObject(){
		Login login=new Login();
		return login;
	}
	
    
	@RequestMapping(value="doLogin.htm",method=RequestMethod.GET)
	public ModelAndView dologin(@ModelAttribute("login")Login login,Errors errors){
		ModelAndView mv=new ModelAndView();
		//ValidationUtils.invokeValidator(loginValidator, login, errors);
    	if(errors.hasErrors())
    	{
    		mv.setViewName("login");
    	}
    	else{
		boolean adminLogin=loginService.checkLogin(login);
		if(adminLogin) {
			List<Admin>adminList=adminService.getAllAdmin();
			mv.addObject("adminList",adminList);
	    	mv.setViewName("home");
	    	return mv;
		}
		else {
			mv.addObject("status","Login failed");
		}
		mv.setViewName("login");
    	}
		return mv;	
	}
	
	
	
	@RequestMapping(value="index.htm",method=RequestMethod.GET)
	public String loadFrontForm(){
		return "welcome";
	}
	
	@RequestMapping(value="login.htm",method=RequestMethod.GET)
	public String loadLoginForm(){
		System.out.println("---Loading---");
		return "login";
	}
	
	 @RequestMapping(value="registration.htm",method=RequestMethod.GET)
	   public ModelAndView loadForm(){
		 List<String> gender=new ArrayList<String>();
		 gender.add("Male");
		 gender.add("Female");
		 ModelAndView mv=new ModelAndView();
		 mv.addObject("Gender",gender);
		 mv.setViewName("registration");
		   return mv;
	 }
	 
	 @RequestMapping(value="home.htm",method=RequestMethod.GET)
		public String loadHomeForm(){
			System.out.println("---Loading---");
			return "home";
		}
	
	
	@ModelAttribute("admin")
	public Admin createCommandobject()
	{
		Admin admin=new Admin();
		return admin;
	}
	
	
	@RequestMapping(value="doRegistration.htm",method=RequestMethod.GET)
    public ModelAndView persistAdmin(@ModelAttribute("admin")Admin admin,Errors errors)
    {    	
    	ModelAndView mv=new ModelAndView();
    	
    	ValidationUtils.invokeValidator(registrationValidator, admin, errors);
    	if(errors.hasErrors())
    	{
    		mv.setViewName("registration");
    	}
    	else{
		boolean persistAdmin=adminService.persistsAdmin(admin);
		
		if(persistAdmin){
			mv.addObject("status", "Admin sucessfully registered");
			List<Admin> adminList=adminService.getAllAdmin();
	    	mv.addObject("adminList",adminList);
	    	mv.setViewName("adminid");
	    	return mv;	
		}
		else
		{
			mv.addObject("status"," registration failed");
		}
    	
		mv.setViewName("registration");
    	}
    	return mv;
    }
	
	 @RequestMapping(value="logoutUser.htm",method=RequestMethod.GET )
	    public ModelAndView logoutAdmin(HttpSession httpSession){
	    	ModelAndView mv=new ModelAndView();
	    	httpSession.invalidate();
	    	mv.setViewName("login");
	    	return mv;	
	    }
    
	 @ModelAttribute("patient")
		public Patient createPatientobject()
		{
			Patient patient=new Patient();
			return patient;
		}
	 @RequestMapping(value="addPatientPage.htm",method=RequestMethod.GET)
		public ModelAndView loadPatientForm(){
			List<String> gender=new ArrayList<String>();
			 gender.add("Male");
			 gender.add("Female");
			 ModelAndView mv=new ModelAndView();
			 mv.addObject("Gender",gender);
			 mv.setViewName("addpatient");
			return mv;
		}
	 
	 @RequestMapping(value="addPatientDetails.htm",method=RequestMethod.GET)
	  public ModelAndView addPatientDetails(@ModelAttribute("patient")Patient patient,Errors errors){
		
		 ModelAndView mv=new ModelAndView();
			//ValidationUtils.invokeValidator(validator, patient, errors);
			
				boolean persistPatient=patientService.patientPersist(patient);
				if(persistPatient)
				{
					mv.addObject("status", "Patient Sucessfully registered");
					List<Patient> patientList=patientService.getAllPatients();
					mv.addObject("patientList", patientList);
					mv.setViewName("viewpatient");
					return mv;
				}
				else
				{
					mv.addObject("status", "Registered failed");	
				}mv.setViewName("addpatient");
				
			return mv;
		 
	 }
	 
	 @RequestMapping(value="viewpatient.htm",method=RequestMethod.GET)
		public ModelAndView viewPatientDetails()
		{
			List<Patient> patientList= patientService.getAllPatients();
			ModelAndView mv=new ModelAndView();
			mv.addObject("patientList", patientList);
			mv.setViewName("viewpatient");
			return mv;
		}
	 
	 @RequestMapping(value="showPatientDetails.htm",method=RequestMethod.GET)
		public ModelAndView showPatientDetails(@RequestParam("patientId")String patientId,ModelMap map)
		{ 
		 
			Patient patient=patientService.getPatientObject(patientId);
			patient.getAge();
			map.addAttribute("updatePatient",patient);
			ModelAndView mv=new ModelAndView();
			mv.setViewName("displaypatientdetails");
			return mv;
		}
	 
	 @RequestMapping(value="updatePatientDetails.htm",method=RequestMethod.GET)
	 public ModelAndView updatePatientDetails(@ModelAttribute("updatePatient")Patient patient,Errors errors){
		ModelAndView mv=new ModelAndView();
		boolean updatePatient=patientService.patientUpdate(patient);
		List<Patient> patientList=patientService.getAllPatients();
		mv.addObject(patientList);
		mv.setViewName("displaypatientdetails");
		 return mv;
		 
	 }
	
	 
	 @RequestMapping(value="editPatient.htm",method=RequestMethod.GET)
		public ModelAndView loadUpdatePatientForm(){
			List<String> gender=new ArrayList<String>();
			 gender.add("Male");
			 gender.add("Female");
			 ModelAndView mv=new ModelAndView();
			 mv.addObject("Gender",gender);
			 mv.setViewName("updatepatient");
			return mv;
		}
	 
	 
	 
	 @ModelAttribute("physician")
		public Physician createPhysicianobject()
		{
		 Physician physician=new Physician();
			return physician;
		}
	 
	 @RequestMapping(value="addPhysicianPage.htm",method=RequestMethod.GET)
		public ModelAndView loadPhysicianForm(){
		 	 List<String> gender=new ArrayList<String>();
			 gender.add("Male");
			 gender.add("Female");
			 ModelAndView mv=new ModelAndView();
			 mv.addObject("Gender",gender);
			 
			 List<String> workHours=new ArrayList<String>();
			 workHours.add("3");
			 workHours.add("6");
			 workHours.add("9");
			 mv.addObject("Work_Hours",workHours);
			 
			 mv.setViewName("addphysician");
			return mv;
		}
	 
	 @RequestMapping(value="addPhysicianDetails.htm",method=RequestMethod.GET)
	  public ModelAndView addPhysicianDetails(@ModelAttribute("physician")Physician physician,Errors errors){
		
		 ModelAndView mv=new ModelAndView();
			//ValidationUtils.invokeValidator(validator, patient, errors);
			
				boolean persistPhysician=physicianService.physicianPersist(physician);
				if(persistPhysician)
				{
					mv.addObject("status", "Physician Sucessfully registered");
					List<Physician> physicianList=physicianService.getAllPhysicians();
					mv.addObject("physicianList", physicianList);
					mv.setViewName("viewphysician");
					return mv;
				}
				else
				{
					mv.addObject("status", "Registered failed");	
				}mv.setViewName("addphysician");
				
			return mv;
		 
	 }
	 
	 @RequestMapping(value="viewphysician.htm",method=RequestMethod.GET)
		public ModelAndView viewPhysicianDetails()
		{
			List<Physician> physicianList= physicianService.getAllPhysicians();
			ModelAndView mv=new ModelAndView();
			mv.addObject("physicianList", physicianList);
			mv.setViewName("viewphysician");
			return mv;
		}
	 
	 @RequestMapping(value="showPhysicianDetails.htm",method=RequestMethod.GET)
		public ModelAndView showPhysicianDetails(@RequestParam("physicianId")String physicianId,ModelMap map)
		{ 
		 
			Physician physician=physicianService.getPhysicianObject(physicianId);
			physician.getAge();
			map.addAttribute("updatePhysician",physician);
			ModelAndView mv=new ModelAndView();
			mv.setViewName("displayphysiciandetails");
			return mv;
		}
	
	 @RequestMapping(value="editPhysician.htm",method=RequestMethod.GET)
		public ModelAndView loadUpdatePhysicianForm(){
			List<String> gender=new ArrayList<String>();
			 gender.add("Male");
			 gender.add("Female");
			 ModelAndView mv=new ModelAndView();
			 mv.addObject("Gender",gender);
			 mv.setViewName("updatephysician");
			return mv;
		}
	 
	 @RequestMapping(value="updatePhysicianDetails.htm",method=RequestMethod.GET)
	 public ModelAndView updatePhysicianDetails(@ModelAttribute("updatePhysician")Physician physician,Errors errors){
		ModelAndView mv=new ModelAndView();
		boolean updatePhysician=physicianService.physicianUpdate(physician);
		List<Physician> physicianList= physicianService.getAllPhysicians();
		mv.addObject(physicianList);
		mv.setViewName("displayphysiciandetails");
		 return mv;
		 
	 }
	 
	 public String firstName = "";
	 public String lastName = "";
	 public String password = "";
	 public int age=0;
	 public void AllAdminDetails(@ModelAttribute("admin")Admin admin)
	 {
		 firstName = admin.getFirstName();
		 lastName = admin.getLastName();
		 password = admin.getPassword();
		 age = admin.getAge();
	 }
}
