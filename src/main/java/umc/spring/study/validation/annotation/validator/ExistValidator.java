package umc.spring.study.validation.annotation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.study.apiPayload.code.status.ErrorStatus;
import umc.spring.study.service.StoreService.StoreQueryService;
import umc.spring.study.validation.annotation.ExistStore;

@Component
@RequiredArgsConstructor
public class ExistValidator implements ConstraintValidator<ExistStore, Long> {

    private final StoreQueryService storeQueryService;


    @Override
    public void initialize(ExistStore constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }


    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        boolean isValid = storeQueryService.findStore(value).isPresent();
        System.out.println("[VALIDATOR] storeId: " + value + ", exists: " + isValid);

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.STORE_NOT_FOUND.name())
                    .addConstraintViolation();
        }

        return isValid;
    }

}