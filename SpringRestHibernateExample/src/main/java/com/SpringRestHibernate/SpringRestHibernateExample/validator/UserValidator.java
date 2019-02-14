package com.SpringRestHibernate.SpringRestHibernateExample.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.SpringRestHibernate.SpringRestHibernateExample.dao.RegisterDao;
import com.SpringRestHibernate.SpringRestHibernateExample.model.Register;

@Component
public class UserValidator implements Validator {
    
	@Autowired
    private RegisterDao registerDao;

    @Override
    public boolean supports(Class<?> aClass) {
        return RegisterDao.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Register user = (Register) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        if (user.getUserName().length() < 6 || user.getUserName().length() > 32) {
            errors.rejectValue("username", "Size.userForm.username");
        }
        if (registerDao.findByUsername(user.getUserName()) != null) {
            errors.rejectValue("username", "Duplicate.userForm.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (user.getPass().length() < 8 || user.getPass().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }
    }
}