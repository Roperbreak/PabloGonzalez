package es.gonzalez.AcademyBoxIt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.gonzalez.AcademyBoxIt.model.UserType;
import es.gonzalez.AcademyBoxIt.model.dao.UserTypeDao;
import es.gonzalez.AcademyBoxIt.service.UserTypeSvc;
import es.gonzalez.AcademyBoxIt.service.exceptions.UserTypeSvcException;

@Service
@Transactional
public class UserTypeSvcImpl implements UserTypeSvc {

	@Autowired
	private UserTypeDao typeuserdao;

	@Override
	public List<UserType> showTypes() throws UserTypeSvcException {

		List<UserType> list = null;

		try {

			list = typeuserdao.listTypes();

		} catch (Exception ex) {
			throw new UserTypeSvcException(ex);
		}

		return list;
	}

}
