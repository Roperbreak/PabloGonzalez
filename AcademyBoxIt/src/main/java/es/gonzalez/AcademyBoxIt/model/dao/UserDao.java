package es.gonzalez.AcademyBoxIt.model.dao;

import java.util.List;

import es.gonzalez.AcademyBoxIt.model.User;
import es.gonzalez.AcademyBoxIt.model.dao.exceptions.UserDaoException;

public interface UserDao {

	public List<User> findbyName() throws UserDaoException;

	public User findById(Integer id) throws UserDaoException;

	public User userLogin(String dni, String password) throws UserDaoException;

	// posible falla por id AI
	public void saveUser(User user) throws UserDaoException;

	public void updateUser(User user) throws UserDaoException;

	public void deleteUser(User user) throws UserDaoException;

}
