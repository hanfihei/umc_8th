package umc.spring.study.web.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import umc.spring.study.validation.annotation.ExistCategories;

import java.time.LocalDate;


public class MissionRequestDTO {

    @Setter
    @Getter
    public static class AddMissionDto{


        @NotNull
        private Long missionId;

        @NotBlank
        private String name;

        @NotNull
        private Integer point;

        @NotNull
        private LocalDate completionDate;

        @NotBlank
        private String text;
    }

}
