package com.cts;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LuhnCheckValidator implements ConstraintValidator<LuhnCheck, String> {


	   public void initialize(LuhnCheck constraintAnnotation) {
	   }
	   
	   public boolean isValid(String value, ConstraintValidatorContext context) {
	      return luhnCheck(value.replaceAll("\\D", "")); // remove non-digits
	   }
	   
	   private static boolean luhnCheck(String cardNumber) {
	      int sum = 0;
	      
	      for(int i = cardNumber.length() - 1; i >= 0; i -= 2) {
	         sum += Integer.parseInt(cardNumber.substring(i, i + 1));
	         
	      }
	      
	      return sum % 10 == 0;
	   }
}
