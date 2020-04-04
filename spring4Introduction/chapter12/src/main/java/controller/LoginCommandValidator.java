package controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * @author Seunghyun Kim
 * @since 2020-04-04
 */
public class LoginCommandValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return LoginCommand.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required");
        ValidationUtils.rejectIfEmpty(errors, "password", "required");
    }
}
