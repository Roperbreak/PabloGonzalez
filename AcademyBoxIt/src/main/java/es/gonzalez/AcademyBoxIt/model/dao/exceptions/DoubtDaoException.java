package es.gonzalez.AcademyBoxIt.model.dao.exceptions;

public class DoubtDaoException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DoubtDaoException(Exception ex) {
		super(ex);
	}

	public DoubtDaoException(String msg) {
		super(msg);
	}

}
