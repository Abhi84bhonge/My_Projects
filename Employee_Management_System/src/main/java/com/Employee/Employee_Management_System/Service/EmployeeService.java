package com.Employee.Employee_Management_System.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Employee.Employee_Management_System.DAO.EmployeeRepository;
import com.Employee.Employee_Management_System.DAO.LoginRepository;
import com.Employee.Employee_Management_System.Entity.Employee;
import com.Employee.Employee_Management_System.Entity.Login;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repo;

	@Autowired
	private LoginRepository log;

	public List<Employee> getallemployee() {
		return repo.findAll();
	}

	
	public Employee getemployeebyId(Integer id) {
	    return repo.findById(id).orElse(null); // returns null if not found
	}

	public Employee updateempbyId(Integer id) {
		return repo.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));

	}

	public void registerEmployee(Employee emp) {
		repo.save(emp);
	}

	public void deleteEmployeeById(Integer id) {
		Employee emp = repo.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
		repo.delete(emp);
	}

	public boolean addadmin(Login lg) {
		Login existing = log.findByUsername(lg.getUsername());
		if (existing != null) {
			return false;
		}
		log.save(lg);
		System.out.println("Admin saved " + lg.getUsername());
		return true;
	}

	public boolean getLogin(String username, String password) {
		Login lg = log.findByUsername(username);
		if (lg != null && lg.getPassword().equals(password)) {
			return true;
		} else {
			return false;
		}

	}

}
