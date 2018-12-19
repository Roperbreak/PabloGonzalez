package es.gonzalez.AcademyBoxIt.model.dao.exceptions;

public class UserTypeDaoException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserTypeDaoException(String msg) {
		super(msg);
	}

	public UserTypeDaoException(Exception ex) {
		super(ex);
	}
}
