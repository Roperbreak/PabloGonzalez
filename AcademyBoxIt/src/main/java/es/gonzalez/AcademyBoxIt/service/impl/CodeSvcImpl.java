package es.gonzalez.AcademyBoxIt.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import es.gonzalez.AcademyBoxIt.model.Code;
import es.gonzalez.AcademyBoxIt.model.User;
import es.gonzalez.AcademyBoxIt.model.dao.CodeDao;
import es.gonzalez.AcademyBoxIt.service.CodeSvc;
import es.gonzalez.AcademyBoxIt.service.exceptions.CodeSvcException;
import es.gonzalez.AcademyBoxIt.service.exceptions.UserSvcException;

@Service
@Transactional
public class CodeSvcImpl implements CodeSvc {

	@Autowired
	private CodeDao codeDao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void sendCode(Code code, User alumn) throws CodeSvcException {

		try {

			code.setUser(alumn);
			code.setPostdate(new Date());
			code.setMarks(0.0);
			codeDao.saveCode(code);

		} catch (Exception ex) {
			throw new CodeSvcException(ex);
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void markCode(Code code, Double mark) throws CodeSvcException {

		try {
			code.setMarks(mark);
			codeDao.updateCode(code);
		} catch (Exception ex) {
			throw new CodeSvcException(ex);
		}

	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Code findById(Integer id) throws CodeSvcException{
		Code res = null;
		try {

			res = codeDao.findById(id);

		} catch (Exception ex) {
			throw new CodeSvcException(ex);
		}

		return res;

	}

	
}
