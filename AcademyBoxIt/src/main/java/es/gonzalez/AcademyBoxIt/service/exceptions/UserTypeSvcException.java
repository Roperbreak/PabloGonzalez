package es.gonzalez.AcademyBoxIt.service.exceptions;

public class UserTypeSvcException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserTypeSvcException(String msg) {
		super(msg);

	}

	public UserTypeSvcException(Exception ex) {
		super(ex);
	}

}
