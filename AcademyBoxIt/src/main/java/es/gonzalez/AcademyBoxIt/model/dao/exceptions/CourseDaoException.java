package es.gonzalez.AcademyBoxIt.model.dao.exceptions;

public class CourseDaoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CourseDaoException(String msg) {
		super(msg);
	}

	public CourseDaoException(Exception ex) {
		super(ex);
	}
}
