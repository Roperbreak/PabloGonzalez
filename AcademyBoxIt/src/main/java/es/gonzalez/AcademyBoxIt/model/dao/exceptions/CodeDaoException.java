package es.gonzalez.AcademyBoxIt.model.dao.exceptions;

public class CodeDaoException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CodeDaoException(String msg) {
		super(msg);
	}

	public CodeDaoException(Exception ex) {
		super(ex);
	}
}
