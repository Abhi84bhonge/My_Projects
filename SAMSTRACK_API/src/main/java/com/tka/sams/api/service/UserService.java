package com.tka.sams.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.sams.api.dao.UserDao;
import com.tka.sams.api.entity.User;
import com.tka.sams.api.model.LoginRequest;

@Service
public class UserService {

	
	//JPA SERVICE LAYER
	@Autowired
    private UserDao userDao;

    // LOGIN
    public User loginUser(LoginRequest request) {
        return userDao.findByUsernameAndPassword(
                request.getUsername(),
                request.getPassword()
        );
    }

    // REGISTER
    public User registerUser(User user) {
        if (!userDao.existsById(user.getUsername())) {
            return userDao.save(user);
        }
        return null;
    }

    // GET USER BY NAME
    public User getUserByName(String username) {
        return userDao.findById(username).orElse(null);
    }

    // GET ALL USERS
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    // UPDATE USER
    public User updateUser(User user) {
        return userDao.save(user);
    }

    // DELETE USER
    public String deleteUserById(String username) {
        userDao.deleteById(username);
        return "deleted";
    }

    // GET ADMINS
    public List<User> getAllAdmins() {
        return userDao.findByRole("admin");
    }

    // GET FACULTIES
    public List<User> getAllFaculties() {
        return userDao.findByRole("faculty");
    }
}
	
	
	
	
	
	
	
	
	
	//ORM SERVICE LAYER
//	@Autowired
//	private UserDao dao;
//
//	public User loginUser(LoginRequest request) {
//		return dao.loginUser(request);
//	}
//
//	public User registerUser(User user) {
//		return dao.registerUser(user);
//	}
//
//	public User getUserByName(String username) {
//		return dao.getUserByName(username);
//	}
//
//	public List<User> getAllUser() {
//		return dao.getAllUser();
//	}
//
//	public User updateUser(User user) {
//		return dao.updateUser(user);
//	}
//
//	public String deleteUserById(String username) {
//		return dao.deleteUserById(username);
//	}
//
//	public List<User> getAllAdmins() {
//		return dao.getAllAdmins();
//	}
//	
//	public List<User> getAllFaculties() {
//		return dao.getAllFaculties();
//	}
//
//}
