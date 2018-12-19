package es.gonzalez.AcademyBoxIt.service;

import java.util.List;

import es.gonzalez.AcademyBoxIt.model.User;
import es.gonzalez.AcademyBoxIt.model.UserType;
import es.gonzalez.AcademyBoxIt.service.exceptions.UserSvcException;

public interface UserSvc {

	public List<User> listUsers(UserType type) throws UserSvcException;

	public User login(String user, String password) throws UserSvcException;

	public User findById(Integer id) throws UserSvcException;

	public void deleteUser(User user) throws UserSvcException;

	public void updateUser(User user) throws UserSvcException;

	public void changePwd(String password, User user) throws UserSvcException;
	/*
	 * IMPLANTARLO TODO EN UNO * if(password!=null) { user.setPassword(password); }
	 * 
	 * if(email!=null) { user.setEmail(email); }
	 * 
	 * if(course!=null) { user.setCourse(course); }
	 */

	public Double calculateMark(Double mark, Double gauss) throws UserSvcException;

	public void saveUser(User user) throws UserSvcException;
	


}
