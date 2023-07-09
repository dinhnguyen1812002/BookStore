package Tuan2._LeNguyenDinhNguyen.Validator;

import Tuan2._LeNguyenDinhNguyen.Validator.annotation.ValidUsername;
import Tuan2._LeNguyenDinhNguyen.repository.IUserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class ValidUsernameValidator implements ConstraintValidator<ValidUsername, String> {
    @Autowired
    private IUserRepository userRepository;
    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
        if(userRepository == null) return true;
        return userRepository.findByUserName(username)== null;
    }
}
