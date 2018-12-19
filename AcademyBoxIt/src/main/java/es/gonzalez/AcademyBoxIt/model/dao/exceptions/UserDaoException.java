package es.gonzalez.AcademyBoxIt.model.dao.exceptions;

public class UserDaoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserDaoException(String msg) {
		super(msg);
	}

	public UserDaoException(Exception ex) {
		super(ex);
	}
}
