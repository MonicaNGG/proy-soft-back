package ucentral.edu.co.mikaza.mapper;

import ucentral.edu.co.mikaza.dto.user.UserInformationDto;
import ucentral.edu.co.mikaza.model.User;

public class UserInformationMapper {
    public static UserInformationDto modelToDto(User user) {
        return UserInformationDto.builder()
                .email(user.getEmail())
                .verificationCode(user.getVerificationCode())
                .enabled(user.isEnabled())
                .build();
    }
}
