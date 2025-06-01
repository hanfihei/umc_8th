package umc.spring.study.validation.annotation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.study.apiPayload.code.status.ErrorStatus;
import umc.spring.study.domain.enums.MissionStatusType;
import umc.spring.study.service.Mission2Service.Mission2QueryService;
import umc.spring.study.validation.annotation.AlreadyOngoing;
import umc.spring.study.web.dto.UserRequestDTO;

@Component
@RequiredArgsConstructor
public class OngoingValidator implements ConstraintValidator<AlreadyOngoing, UserRequestDTO.AddMissionDto> {


    private final Mission2QueryService mission2QueryService;

    @Override
    public void initialize(AlreadyOngoing constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(UserRequestDTO.AddMissionDto request, ConstraintValidatorContext context) {
        boolean isValid = mission2QueryService.findMissionsForUserByStatus(request.getUserId(), request.getMissionId(), MissionStatusType.ONGOING).isPresent();

        if (isValid) {
            context.disableDefaultConstraintViolation();
            //context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_ALREADY_IN_PROGRESS.toString()).addConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_ALREADY_IN_PROGRESS.getMessage());
            }

        return !isValid;

    }
}

