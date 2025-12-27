package com.Employee.Employee_Management_System.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.Employee.Employee_Management_System.Entity.Employee;
import com.Employee.Employee_Management_System.Entity.Login;
import com.Employee.Employee_Management_System.Service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@GetMapping("/index")
	public String get() {
		return "index";
	}

	//Add admin for Login Page
	@GetMapping("/getadminpage")
	public String getadminPage() {
		return "getadminpage";
	}

	@PostMapping("/getadminpage")
	public String addadmin(@ModelAttribute Login lg, Model model) {
		boolean add = service.addadmin(lg);
		if (add) {
			return "redirect:/login";
		} else {
			model.addAttribute("error", "Admin already exists or failed to save.");
			return "getadminpage";
		}
	}

	@GetMapping("/login")
	public String getloginpage() {
		return "login";
	}

	@GetMapping("/operations")
	public String getoperationspage() {
		return "operations";
	}
	
	
	@PostMapping("/login")
	public String getLogin(@RequestParam String username, @RequestParam String password, Model model) {

		boolean valid = service.getLogin(username, password);

		if (valid) {
			return "redirect:/operations";
		} else {
			model.addAttribute("error", "!!!Invalid Username or Password!!!");
			return "login";
		}
	}

//	Register Employee

	@GetMapping("/register")
	public String openRegisterPage() {
		return "register";
	}

	@PostMapping("/register")
	public String registerEmployee(@ModelAttribute Employee emp) {
		service.registerEmployee(emp);
		return "success";
	}

//	Get All employee

	@GetMapping("/allemployees")
	public String getallemployee(Model model) {
		model.addAttribute("employees", service.getallemployee());
		return "allemployees";
	}

//	Get Employee By ID 

	@GetMapping("/getEmpbyId")
	public String showSearchPage() {
		return "getEmpbyId";
	}

	@PostMapping("/getEmpbyId")
	public String getEmployeeById(@RequestParam Integer id, Model model) {

		try {
			Employee emp = service.getemployeebyId(id);
			model.addAttribute("emp", emp);
		} catch (Exception ex) {
			model.addAttribute("emp", null);
		}
		return "getEmpbyId";
	}

//	Update Employee 

	@GetMapping("/updatebyId")
	public String showUpdateIdPage() {
		return "updatebyId";
	}

	@PostMapping("/updatebyId")
	public String fetchEmployeeForUpdate(@RequestParam Integer id, Model model) {
	    Employee emp = service.getemployeebyId(id);

	    if (emp == null) {
	        model.addAttribute("msg", "Employee not found!");
	        return "updatebyId"; 
	    }

	    model.addAttribute("emp", emp);
	    return "updateByIdForm"; 
	}

	@PostMapping("/updateEmployee")
	public String updateEmployee(@ModelAttribute Employee emp, Model model) {
		service.registerEmployee(emp);
		model.addAttribute("msg", "Employee Updated Successfully!");
		return "successupdateemp";
	}

	// Delete employee by ID

	@GetMapping("/deletebyId")
	public String showdeleteIdPage() {
		return "deletebyId";
	}

	@PostMapping("/deletebyId")
	public String getempfordelete(@RequestParam Integer id, Model model) {

		try {
			Employee emp = service.getemployeebyId(id);
			model.addAttribute("emp", emp);
		} catch (Exception ex) {
			model.addAttribute("emp", null);
			model.addAttribute("msg", "Employee not found");
		}
		return "deleteByIdForm";
	}

	@PostMapping("/deleteEmployee")
	public String deleteEmployee(@RequestParam Integer id, Model model) {
		try {
			service.deleteEmployeeById(id);
			model.addAttribute("msg", "Employee deleted successfully!");
		} catch (Exception ex) {
			model.addAttribute("msg", "Error deleting employee: " + ex.getMessage());
		}
		return "successdelete";
	}

}
