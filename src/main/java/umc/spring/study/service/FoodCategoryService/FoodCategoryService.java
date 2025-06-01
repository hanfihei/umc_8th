package umc.spring.study.service.FoodCategoryService;

import java.util.List;

public interface FoodCategoryService {
    boolean doAllCategoriesExist(List<Long> ids);
}
