package es.gonzalez.AcademyBoxIt.service.exceptions;

public class DoubtSvcException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DoubtSvcException(Exception ex) {
		super(ex);
	}

	public DoubtSvcException(String msg) {
		super(msg);
	}

}
