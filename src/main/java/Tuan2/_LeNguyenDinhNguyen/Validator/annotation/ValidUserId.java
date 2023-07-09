package Tuan2._LeNguyenDinhNguyen.Validator.annotation;

import Tuan2._LeNguyenDinhNguyen.Validator.ValidUserIdValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidUserIdValidator.class)
@Documented
public @interface ValidUserId {
    String message() default "Invalid user ID";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
