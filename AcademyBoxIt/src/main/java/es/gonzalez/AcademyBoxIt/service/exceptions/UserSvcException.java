package es.gonzalez.AcademyBoxIt.service.exceptions;

public class UserSvcException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserSvcException(String msg) {
		super(msg);

	}

	public UserSvcException(Exception ex) {
		super(ex);
	}

}
