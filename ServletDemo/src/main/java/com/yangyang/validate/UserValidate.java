package com.yangyang.validate;

import com.yangyang.model.User;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UserValidate implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User)target;
        if(user.getUsername().length() < 8){
            errors.rejectValue("username","valid.username","姓名长不能小于8");
        }
        if(user.getPassword().length() < 4){
            errors.rejectValue("password","valid.password","密码长度不能小于4");
        }
    }
}
