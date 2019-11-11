package com.well.br.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext; 

public class CourceCodeConstraintValidator implements ConstraintValidator<CourseCode, String>{
	
	public String[] coursePrefix; 
	
	public void initialize(CourseCode theCourseCode ) {
		this.coursePrefix = theCourseCode.value(); 
	}
	
	@Override
	public boolean isValid(String theCode, 
					ConstraintValidatorContext theConstraintValidatorContext) {
		 
		;
		
		for(String prefix : coursePrefix  ) {
			if(theCode.startsWith(prefix))
				return true;
		}
		return false;
	}


}
