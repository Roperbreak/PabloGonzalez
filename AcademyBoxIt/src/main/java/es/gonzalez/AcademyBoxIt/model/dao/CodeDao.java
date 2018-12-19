package es.gonzalez.AcademyBoxIt.model.dao;

import java.util.Date;
import java.util.List;

import es.gonzalez.AcademyBoxIt.model.Code;
import es.gonzalez.AcademyBoxIt.model.Course;
import es.gonzalez.AcademyBoxIt.model.User;
import es.gonzalez.AcademyBoxIt.model.dao.exceptions.CodeDaoException;
import es.gonzalez.AcademyBoxIt.service.exceptions.CodeSvcException;

public interface CodeDao {

	public List<Code> listUserCodes(User user, Date d, Course course) throws CodeDaoException;

	public void saveCode(Code code) throws CodeDaoException;

	public void deleteCode(Code code) throws CodeDaoException;

	public Code findById(Integer id) throws CodeDaoException;
	
	public void updateCode(Code code) throws CodeDaoException;


}
