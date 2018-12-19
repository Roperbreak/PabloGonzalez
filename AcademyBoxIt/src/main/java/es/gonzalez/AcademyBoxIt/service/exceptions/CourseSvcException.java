package es.gonzalez.AcademyBoxIt.service.exceptions;

public class CourseSvcException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CourseSvcException(String msg) {
		super(msg);

	}

	public CourseSvcException(Exception ex) {
		super(ex);
	}

}
