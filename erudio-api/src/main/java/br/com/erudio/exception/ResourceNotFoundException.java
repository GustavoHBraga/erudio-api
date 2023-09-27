package br.com.erudio.exception;

public class ResourceNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID  = 1L;
	
	public ResourceNotFoundException(String ex) {
		super(ex);
	}
	
}
