package umc.spring.study.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import umc.spring.study.domain.User;
import umc.spring.study.repository.UserRepository.UserRepository;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("🔍 로그인 시도 이메일: " + username);  // 로그 추가

        User user = userRepository.findByEmail(username)
                .orElseThrow(() -> {
                    System.out.println("❌ 사용자 없음: " + username); // 로그 추가
                    return new UsernameNotFoundException("해당 이메일을 가진 유저가 존재하지 않습니다: " + username);
                });

        System.out.println("✅ 사용자 찾음: " + user.getEmail());
        System.out.println("✅ DB 저장 비번: " + user.getPassword());

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getEmail())
                .password(user.getPassword())
                .roles(user.getRole().name())
                .build();
    }
}