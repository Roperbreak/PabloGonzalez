package es.gonzalez.AcademyBoxIt.model.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.gonzalez.AcademyBoxIt.model.Code;
import es.gonzalez.AcademyBoxIt.model.Course;
import es.gonzalez.AcademyBoxIt.model.User;
import es.gonzalez.AcademyBoxIt.model.dao.CodeDao;
import es.gonzalez.AcademyBoxIt.model.dao.exceptions.CodeDaoException;
import es.gonzalez.AcademyBoxIt.model.dao.exceptions.UserDaoException;
import es.gonzalez.AcademyBoxIt.service.exceptions.CodeSvcException;

@Repository
public class CodeDaoImpl implements CodeDao {

	@Autowired
	private SessionFactory sessionFactory;

	// POSIBLE FALLA EN EL CASO DE DELETE GET//
	@SuppressWarnings("unchecked")
	@Override
	// POSIBLE INCOMPATIBILIDAD CON EL SET
	public List<Code> listUserCodes(User user, Date d, Course course) throws CodeDaoException {

		List<Code> usercodes = null;

		// ESTO CUBRE LA BUSQUEDA DE: USUARIO FECHA CURSO DIRECTO + SI NO HAY USUARIO
		// POR FECHA
		// Y POR CURSO.

		try {
			String hql = "FROM Code code WHERE";

			if (course == null && user == null && d == null) {
				hql = "FROM Code code";
			}

			if (user != null) {
				hql = hql + " user.id=" + user.getId();
				if (d != null) {
					hql = hql + " AND code.postdate=" + d;
				}
			} else {

				if (d != null) {
					hql = hql + " code.postdate=" + d;
				}

				if (course != null) {
					hql = hql + " course.idclass=" + course.getIdclass();
				}

			}

			usercodes = (List<Code>) sessionFactory.getCurrentSession().createQuery(hql).list();

		} catch (Exception ex) {
			throw new CodeDaoException(ex);
		}

		return usercodes;
	}

	@Override
	public void saveCode(Code code) throws CodeDaoException {

		try {

			sessionFactory.getCurrentSession().save(code);

		} catch (Exception ex) {
			throw new CodeDaoException(ex);
		}

	}

	@Override
	public void deleteCode(Code code) throws CodeDaoException {
		try {

			sessionFactory.getCurrentSession().delete(code);

		} catch (Exception ex) {
			throw new CodeDaoException(ex);
		}

	}

	@Override
	public Code findById(Integer id) throws CodeDaoException {
		Code res = null;
		try {
			String hql = "FROM Code code WHERE code.id=:id";
			res = (Code) sessionFactory.getCurrentSession().createQuery(hql).setParameter("id", id).uniqueResult();

		} catch (Exception ex) {
			throw new CodeDaoException(ex);
		}

		return res;

	}
	
	@Override
	public void updateCode(Code code) throws CodeDaoException{
		
		try {

			sessionFactory.getCurrentSession().update(code);

		} catch (Exception ex) {
			throw new CodeDaoException(ex);
		}
	}


}
