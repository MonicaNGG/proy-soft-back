package ucentral.edu.co.mikaza.mapper;

import ucentral.edu.co.mikaza.dto.user.UserDto;
import ucentral.edu.co.mikaza.model.User;

public class UserMapper {

    private UserMapper(){};
    public static UserDto modelToDto(User user) {
        return UserDto.builder()
                .name(user.getName())
                .lastName(user.getLastName())
                .documentType(user.getDocumentType())
                .documentNumber(user.getDocumentNumber())
                .phone(user.getPhone())
                .email(user.getEmail())
                .password(user.getPassword())
                .verificationCode(user.getVerificationCode())
                .enabled(user.isEnabled())
                .build();
    }

    public static User dtoToModel(UserDto userDto) {
        return User.builder()
                .name(userDto.getName())
                .lastName(userDto.getLastName())
                .documentType(userDto.getDocumentType())
                .documentNumber(userDto.getDocumentNumber())
                .phone(userDto.getPhone())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .verificationCode(userDto.getVerificationCode())
                .enabled(userDto.isEnabled())
                .build();
    }
}
