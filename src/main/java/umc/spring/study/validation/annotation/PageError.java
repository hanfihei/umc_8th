package umc.spring.study.validation.annotation;

import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Constraint;
import umc.spring.study.validation.annotation.validator.ExistValidator;

import java.lang.annotation.*;

@Documented
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Parameter(hidden = true) //arg1제거
public @interface PageError {
}