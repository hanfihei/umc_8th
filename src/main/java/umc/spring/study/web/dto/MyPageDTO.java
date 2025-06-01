package umc.spring.study.web.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MyPageDTO {
    private Long userId;
    private String name;
    private String email;
    private String phoneNumber;
    private Long point;
}