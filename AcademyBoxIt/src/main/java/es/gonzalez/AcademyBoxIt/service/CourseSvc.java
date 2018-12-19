package es.gonzalez.AcademyBoxIt.service;

import java.util.List;

import es.gonzalez.AcademyBoxIt.model.Course;
import es.gonzalez.AcademyBoxIt.service.exceptions.CourseSvcException;

public interface CourseSvc {

	public List<Course> showTypes() throws CourseSvcException;

}
