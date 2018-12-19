package es.gonzalez.AcademyBoxIt.service;

import java.util.List;

import es.gonzalez.AcademyBoxIt.model.UserType;
import es.gonzalez.AcademyBoxIt.service.exceptions.UserTypeSvcException;

public interface UserTypeSvc {

	public List<UserType> showTypes() throws UserTypeSvcException;

}
