package umc.spring.study.converter;

import umc.spring.study.domain.Mission;
import umc.spring.study.domain.Store;
import java.time.LocalDateTime;

import umc.spring.study.domain.enums.MissionStatusType;
import umc.spring.study.web.dto.MissionResponseDTO;
import umc.spring.study.web.dto.MissionRequestDTO;

public class MissionConverter {

    public static MissionResponseDTO.AddMissionResultDTO AddMissionResultDTO(Mission mission){
        return MissionResponseDTO.AddMissionResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Mission toMission(MissionRequestDTO.AddMissionDto request, Store store){

        return Mission.builder()
                .name(request.getName())
                .point(request.getPoint())
                .completionDate(request.getCompletionDate())
                .text(request.getText())
                .status(MissionStatusType.ONGOING)
                .store(store)
                .build();
    }

}
