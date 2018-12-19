package es.gonzalez.AcademyBoxIt.service.exceptions;

public class CodeSvcException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CodeSvcException(String msg) {
		super(msg);

	}

	public CodeSvcException(Exception ex) {
		super(ex);
	}

}