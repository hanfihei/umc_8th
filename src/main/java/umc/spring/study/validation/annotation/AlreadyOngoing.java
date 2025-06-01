package umc.spring.study.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.spring.study.validation.annotation.validator.OngoingValidator;

import java.lang.annotation.*;


    @Documented
    @Constraint(validatedBy = OngoingValidator.class)
    @Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface AlreadyOngoing {

        String message() default "해당하는 가게가 존재하지 않습니다.";

        Class<?>[] groups() default {};

        Class<? extends Payload>[] payload() default {};
}
