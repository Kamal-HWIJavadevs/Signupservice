package com.hwi.Signupservice.exceptions;

public class ResourceNotFoundException extends RuntimeException {

   
	private static final long serialVersionUID = -5147400124474862675L;
		String resourceName ;
		String fieldName ;
		long fieldValue ;
		public ResourceNotFoundException(String resourceName, String fieldName, long fieldValue) {
			super(String.format("%s not found with %s : %s",resourceName,fieldName,fieldValue));
			this.resourceName = resourceName;
			this.fieldName = fieldName;
			this.fieldValue = fieldValue;
		}
	        
	    }

