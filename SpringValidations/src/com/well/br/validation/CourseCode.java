package com.well.br.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention; 
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
 
@Constraint(validatedBy = CourceCodeConstraintValidator.class)
@Retention(RUNTIME)
@Target({TYPE, FIELD, METHOD })
public @interface CourseCode {

	public String[] value() default {"LUV","TOA"};	
	
	public String message() default "Must start With";//+value[0]+" or "+value[1] ;
	
	public Class<?>[] groups() default {};
	
	public Class<? extends Payload>[] payload() default {};
	
	
}
