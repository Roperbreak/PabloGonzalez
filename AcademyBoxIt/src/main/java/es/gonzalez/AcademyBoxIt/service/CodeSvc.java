package es.gonzalez.AcademyBoxIt.service;

import es.gonzalez.AcademyBoxIt.model.Code;
import es.gonzalez.AcademyBoxIt.model.User;
import es.gonzalez.AcademyBoxIt.service.exceptions.CodeSvcException;
import es.gonzalez.AcademyBoxIt.service.exceptions.UserSvcException;

public interface CodeSvc {

	public void sendCode(Code code, User user) throws CodeSvcException;
	
	public void markCode(Code code, Double mark) throws CodeSvcException;

	public Code findById(Integer id) throws CodeSvcException;

}
