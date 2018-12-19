package es.gonzalez.AcademyBoxIt.model.dao;

import java.util.List;

import es.gonzalez.AcademyBoxIt.model.Course;
import es.gonzalez.AcademyBoxIt.model.dao.exceptions.CourseDaoException;

public interface CourseDao {

	public List<Course> listCourses() throws CourseDaoException;

}
