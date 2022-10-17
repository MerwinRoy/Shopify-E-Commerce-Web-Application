package com.me.shopify.validator;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.me.shopify.pojo.User;


@Component
public class UserValidator implements Validator {

	@Override
    public boolean supports(Class type) {
        return type.equals(User.class);
    }

	@Override
	public void validate(Object o, Errors errors) {
		// TODO Auto-generated method stub
		 ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "emty-name", "Name cannot be empty");
	     ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "emty-address", "Address cannot be empty");
	     ValidationUtils.rejectIfEmptyOrWhitespace(errors, "useremail", "emty-useremail", "Email cannot be empty");
	     ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "emty-password", "Password cannot be empty");
	     ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "emty-phone", "Phone cannot be empty");
	}

}
