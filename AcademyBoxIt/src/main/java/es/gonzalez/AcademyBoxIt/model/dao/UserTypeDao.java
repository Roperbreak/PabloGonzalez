package es.gonzalez.AcademyBoxIt.model.dao;

import java.util.List;

import es.gonzalez.AcademyBoxIt.model.UserType;
import es.gonzalez.AcademyBoxIt.model.dao.exceptions.UserTypeDaoException;

public interface UserTypeDao {

	public List<UserType> listTypes() throws UserTypeDaoException;

}
