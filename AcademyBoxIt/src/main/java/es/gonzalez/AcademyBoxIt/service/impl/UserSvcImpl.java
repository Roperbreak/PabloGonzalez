package es.gonzalez.AcademyBoxIt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import es.gonzalez.AcademyBoxIt.model.User;
import es.gonzalez.AcademyBoxIt.model.UserType;
import es.gonzalez.AcademyBoxIt.model.dao.UserDao;
import es.gonzalez.AcademyBoxIt.model.dao.exceptions.UserDaoException;
import es.gonzalez.AcademyBoxIt.service.UserSvc;
import es.gonzalez.AcademyBoxIt.service.exceptions.UserSvcException;

@Service
@Transactional
public class UserSvcImpl implements UserSvc {

	@Autowired
	private UserDao userDao;

	// public static String fecha() {
	// Date now = new Date();
	// SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
	// return formateador.format(now);
	// }

	@Override

	public Double calculateMark(Double mark, Double gauss) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public User login(String dni, String password) throws UserSvcException {

		User res = null;
		try {
			res = userDao.userLogin(dni, password);

		} catch (Exception ex) {
			throw new UserSvcException(ex);
		}

		return res;
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public List<User> listUsers(UserType type) throws UserSvcException {

		List<User> list = null;
		try {

			list = userDao.findbyName();

		} catch (Exception ex) {
			throw new UserSvcException(ex);

		}

		return list;

	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public User findById(Integer id) throws UserSvcException {
		User res = null;
		try {

			res = userDao.findById(id);

		} catch (Exception ex) {
			throw new UserSvcException(ex);
		}

		return res;

	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void deleteUser(User user) throws UserSvcException {

		try {
			userDao.deleteUser(user);
		} catch (UserDaoException e) {
			throw new UserSvcException(e);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void updateUser(User user) throws UserSvcException {

		try {

			userDao.updateUser(user);

		} catch (UserDaoException e) {
			throw new UserSvcException(e);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void saveUser(User user) throws UserSvcException {
		try {
			if (user.getUsertype()==null) {
				 UserType usertype = new UserType();
			     usertype.setIdtype(1);
			     usertype.setTypename("User");
			     user.setUsertype(usertype);
			}
			userDao.saveUser(user);

		} catch (UserDaoException e) {
			throw new UserSvcException(e);
		}

	}

	@Override
	public void changePwd(String password, User user) throws UserSvcException {
		// TODO Auto-generated method stub

	}
	
}
