package Tuan2._LeNguyenDinhNguyen.Validator;

import Tuan2._LeNguyenDinhNguyen.Validator.annotation.ValidUserId;
import Tuan2._LeNguyenDinhNguyen.entity.User;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidUserIdValidator implements ConstraintValidator<ValidUserId, User> {

    @Override
    public boolean isValid(User user, ConstraintValidatorContext constraintValidatorContext) {
        if(user == null) return true;
        return user.getId() != null;
    }
}
