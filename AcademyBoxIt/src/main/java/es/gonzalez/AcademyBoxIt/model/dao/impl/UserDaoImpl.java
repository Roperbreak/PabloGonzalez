package es.gonzalez.AcademyBoxIt.model.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.gonzalez.AcademyBoxIt.model.User;
import es.gonzalez.AcademyBoxIt.model.dao.UserDao;
import es.gonzalez.AcademyBoxIt.model.dao.exceptions.UserDaoException;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User findById(Integer id) throws UserDaoException {
		User res = null;
		try {
			String hql = "FROM User user WHERE user.id=:id";
			res = (User) sessionFactory.getCurrentSession().createQuery(hql).setParameter("id", id).uniqueResult();

		} catch (Exception ex) {
			throw new UserDaoException(ex);
		}

		return res;

	}

	@Override
	public User userLogin(String dni, String password) throws UserDaoException {
		User res = null;
		try {

			String hql = "FROM User user WHERE user.dni=:userName and user.password=:password";
			res = (User)sessionFactory.getCurrentSession().createQuery(hql)
			.setParameter("userName", dni)
			.setParameter("password", password)
			.getSingleResult();

		} catch (Exception ex) {
			throw new UserDaoException(ex);
		}

		return res;
	}

	@Override
	public void saveUser(User user) throws UserDaoException {

		try {

			sessionFactory.getCurrentSession().save(user);

		} catch (Exception ex) {
			throw new UserDaoException(ex);
		}

	}

	@Override
	public void updateUser(User user) throws UserDaoException {
		try {

			sessionFactory.getCurrentSession().update(user);

		} catch (Exception ex) {
			throw new UserDaoException(ex);
		}

	}

	@Override
	public void deleteUser(User user) throws UserDaoException {
		try {

			sessionFactory.getCurrentSession().delete(user);

		} catch (Exception ex) {
			throw new UserDaoException(ex);
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findbyName() throws UserDaoException {
		List<User> res = null;
		try {
			String hql = "FROM User user";

			res = sessionFactory.getCurrentSession().createQuery(hql).list();

		} catch (Exception ex) {
			throw new UserDaoException(ex);
		}

		return res;

	}

}
