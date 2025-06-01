package umc.spring.study.service.UserService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.study.apiPayload.exception.handler.FoodCategoryHandler;
import umc.spring.study.converter.UserConverter;
import umc.spring.study.converter.UserPreferConverter;
import umc.spring.study.domain.FoodCategory;
import umc.spring.study.domain.mapping.UserPrefer;
import umc.spring.study.repository.FoodCategoryRepository.FoodCategoryRepository;
import umc.spring.study.repository.UserRepository.UserRepository;
import umc.spring.study.web.dto.UserRequestDTO;
import umc.spring.study.domain.User;
import umc.spring.study.apiPayload.code.status.ErrorStatus;


import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserCommandServiceImpl implements UserCommandService {

    private final UserRepository userRepository;
    private FoodCategoryRepository foodCategoryRepository;

    @Override
    @Transactional
    public User joinMember(UserRequestDTO.JoinDto request) {

        User newUser = UserConverter.toMember(request);
        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<UserPrefer> userPreferList = UserPreferConverter.toUserPreferList(foodCategoryList);

        userPreferList.forEach(userPrefer -> userPrefer.setUser(newUser));

        return userRepository.save(newUser);
    }
}
