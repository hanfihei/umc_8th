package umc.spring.study.converter;

import org.springframework.data.domain.Page;
import umc.spring.study.domain.Mission;
import umc.spring.study.domain.User;
import umc.spring.study.domain.enums.MissionStatusType;
import umc.spring.study.domain.mapping.UserMission;
import umc.spring.study.web.dto.UserResponseDTO;
import umc.spring.study.web.dto.UserRequestDTO;
import java.time.LocalDateTime;
import java.util.List;

public class Mission2Converter {

    public static UserResponseDTO.AddMissionResultDTO addResultDTO(UserMission userMission){
        return UserResponseDTO.AddMissionResultDTO.builder()
                .Mission2Id(userMission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static UserMission toMemberMission(UserRequestDTO.AddMissionDto request, User user, Mission mission){

        return UserMission.builder()
                .user(user)
                .mission(mission)
                .status(MissionStatusType.ONGOING)
                    .build();
    }

    public static UserResponseDTO.MyMissionDTO toMyMissionDTO(UserMission userMission) {
        Mission mission = userMission.getMission();

        return UserResponseDTO.MyMissionDTO.builder()
                .name(mission.getName())
                .text(mission.getText())
                .point(mission.getPoint())
                .build();
    }


    public static UserResponseDTO.MyMissionListDTO toMyMissionListDTO(Page<UserMission> missionPage) {
    List<UserResponseDTO.MyMissionDTO> missionList = missionPage.stream()
            .map(Mission2Converter::toMyMissionDTO)
            .toList();

    return UserResponseDTO.MyMissionListDTO.builder()
            .missionList(missionList)
            .build();
}
}
