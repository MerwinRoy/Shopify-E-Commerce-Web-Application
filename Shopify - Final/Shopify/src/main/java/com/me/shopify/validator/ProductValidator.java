package com.me.shopify.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.me.shopify.pojo.Products;

public class ProductValidator implements Validator {
	@Override
    public boolean supports(Class type) {
        return type.equals(Products.class);
    }

	@Override
	public void validate(Object o, Errors errors) {
		// TODO Auto-generated method stub
		 ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "emty-name", "Name cannot be empty");
	     ValidationUtils.rejectIfEmptyOrWhitespace(errors, "quantity", "emty-quantity", "Quantity cannot be empty");
	     ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "emty-price", "Price cannot be empty");
	  	}

}
