package es.gonzalez.AcademyBoxIt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.gonzalez.AcademyBoxIt.model.Course;
import es.gonzalez.AcademyBoxIt.model.dao.CourseDao;
import es.gonzalez.AcademyBoxIt.service.CourseSvc;
import es.gonzalez.AcademyBoxIt.service.exceptions.CourseSvcException;

@Service
@Transactional
public class CourseSvcImpl implements CourseSvc {

	@Autowired
	private CourseDao courseDao;

	@Override
	public List<Course> showTypes() throws CourseSvcException {
		List<Course> list = null;

		try {

			list = courseDao.listCourses();

		} catch (Exception ex) {
			throw new CourseSvcException(ex);
		}

		return list;
	}

}
