package umc.spring.study.service.UserService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
<<<<<<< Updated upstream
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import umc.spring.study.apiPayload.exception.handler.FoodCategoryHandler;
=======
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import umc.spring.study.apiPayload.exception.handler.FoodCategoryHandler;
import umc.spring.study.apiPayload.exception.handler.UserHandler;
>>>>>>> Stashed changes
import umc.spring.study.converter.UserConverter;
import umc.spring.study.converter.UserPreferConverter;
import umc.spring.study.domain.FoodCategory;
import umc.spring.study.domain.mapping.UserPrefer;
import umc.spring.study.repository.FoodCategoryRepository.FoodCategoryRepository;
import umc.spring.study.repository.UserRepository.UserRepository;
import umc.spring.study.web.dto.UserRequestDTO;
import umc.spring.study.domain.User;
import umc.spring.study.apiPayload.code.status.ErrorStatus;
<<<<<<< Updated upstream


=======
import umc.spring.study.web.dto.UserResponseDTO;
import umc.spring.study.config.security.jwt.JwtTokenProvider;

import java.util.Collections;
>>>>>>> Stashed changes
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
<<<<<<< Updated upstream
@Transactional
public class UserCommandServiceImpl implements UserCommandService {

    private final UserRepository userRepository;
    private final FoodCategoryRepository foodCategoryRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public User joinUser(UserRequestDTO.JoinDto request) {
        System.out.println("🚀 회원가입 서비스 진입");

        User newUser = UserConverter.toUser(request);
        newUser.encodePassword(passwordEncoder.encode(request.getPassword()));

        System.out.println("📦 비밀번호 암호화 완료");

        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> {
                    System.out.println("🍱 카테고리 ID: " + category);
                    return foodCategoryRepository.findById(category)
                            .orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<UserPrefer> userPreferList = UserPreferConverter.toUserPreferList(foodCategoryList);
        userPreferList.forEach(up -> up.setUser(newUser));

        newUser.setUserPreferList(userPreferList);

        User savedUser = userRepository.save(newUser);


        return savedUser;
    }
}
=======
public class UserCommandServiceImpl implements UserCommandService{

    private final UserRepository userRepository;

    private final FoodCategoryRepository foodCategoryRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtTokenProvider jwtTokenProvider;


    @Override
    @Transactional
    public User joinUser(UserRequestDTO.JoinDto request) {

        if(userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new UserHandler(ErrorStatus.DUPLICATE_JOIN_REQUEST);
        }

        User newuser = UserConverter.toUser(request);
        newuser.encodePassword(passwordEncoder.encode(request.getPassword()));

        if (!request.getPreferCategory().isEmpty()) {
            List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                    .map(category -> {
                        return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                    }).collect(Collectors.toList());

            List<UserPrefer> userPreferList = UserPreferConverter.toUserPreferList(foodCategoryList);

            userPreferList.forEach(userPrefer -> {
                userPrefer.setUser(newuser);
            });

        }
        return userRepository.save(newuser);
    }

    @Override
    public UserResponseDTO.LoginResultDTO loginUser(UserRequestDTO.LoginRequestDTO request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(()-> new UserHandler(ErrorStatus.MEMBER_NOT_FOUND));

        if(!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new UserHandler(ErrorStatus.INVALID_PASSWORD);
        }

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                user.getEmail(), null,
                Collections.singleton(() -> user.getRole().name())
        );

        String accessToken = jwtTokenProvider.generateToken(authentication);

        return UserConverter.toLoginResultDTO(
                user.getId(),
                accessToken
        );
    }
}

>>>>>>> Stashed changes
