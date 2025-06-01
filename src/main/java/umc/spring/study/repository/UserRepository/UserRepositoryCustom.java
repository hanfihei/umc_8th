package umc.spring.study.repository.UserRepository;

import umc.spring.study.domain.User;
import umc.spring.study.web.dto.MyPageDTO;

public interface UserRepositoryCustom {
    MyPageDTO getMyPage(Long userId);


}
