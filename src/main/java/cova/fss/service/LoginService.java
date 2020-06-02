package cova.fss.service;

import org.springframework.beans.factory.annotation.Autowired;

import cova.fss.dao.UserDao;
import cova.fss.entities.User;

public class LoginService {

	@Autowired 
	UserDao userDao;
	
	public boolean isValid(User user) {
		
		return userDao.validate(user);

	}

}
