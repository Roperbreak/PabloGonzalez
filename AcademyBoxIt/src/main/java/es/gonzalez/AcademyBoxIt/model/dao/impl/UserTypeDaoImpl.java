package es.gonzalez.AcademyBoxIt.model.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.gonzalez.AcademyBoxIt.model.UserType;
import es.gonzalez.AcademyBoxIt.model.dao.UserTypeDao;
import es.gonzalez.AcademyBoxIt.model.dao.exceptions.UserTypeDaoException;

@Repository
public class UserTypeDaoImpl implements UserTypeDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<UserType> listTypes() throws UserTypeDaoException {
		List<UserType> list = null;
		try {
			String hql = "FROM UserType usertype";
			list = sessionFactory.getCurrentSession().createQuery(hql).list();
		} catch (Exception ex) {
			throw new UserTypeDaoException(ex);
		}

		return list;
	}

}
