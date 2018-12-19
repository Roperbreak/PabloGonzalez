package es.gonzalez.AcademyBoxIt.model.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.gonzalez.AcademyBoxIt.model.Course;
import es.gonzalez.AcademyBoxIt.model.dao.CourseDao;
import es.gonzalez.AcademyBoxIt.model.dao.exceptions.CourseDaoException;

@Repository
public class CourseDaoImpl implements CourseDao {

	@Autowired
	private SessionFactory sessionFactory;

	// POSIBLE INCOMPATIBILIDAD CON EL SET

	@SuppressWarnings("unchecked")
	@Override
	public List<Course> listCourses() throws CourseDaoException {

		List<Course> list = null;
		try {

			String hql = "FROM Course course";
			list = sessionFactory.getCurrentSession().createQuery(hql).list();

		} catch (Exception ex) {
			throw new CourseDaoException(ex);
		}

		return list;
	}

}
