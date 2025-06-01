package umc.spring.study.validation.annotation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.study.apiPayload.code.status.ErrorStatus;
import umc.spring.study.repository.FoodCategoryRepository.FoodCategoryRepository;
import umc.spring.study.service.FoodCategoryService.FoodCategoryService;
import umc.spring.study.validation.annotation.ExistCategories;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CategoriesExistValidator implements ConstraintValidator<ExistCategories, List<Long>> {

    private final FoodCategoryService foodCategoryService; //repository 대신 service 주입

    @Override
    public boolean isValid(List<Long> values, ConstraintValidatorContext context) {

        if (values == null || values.isEmpty()) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("카테고리 ID 목록이 비어 있습니다.").addConstraintViolation();
            return false;
        }

            boolean isValid = foodCategoryService.doAllCategoriesExist(values); //서비스 계층에 위임

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.FOOD_CATEGORY_NOT_FOUND.getMessage())
                    .addConstraintViolation();
        }

        return isValid;
    }
}
