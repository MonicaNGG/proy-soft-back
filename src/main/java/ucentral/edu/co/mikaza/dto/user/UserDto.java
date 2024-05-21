package ucentral.edu.co.mikaza.dto.user;

import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;
import ucentral.edu.co.mikaza.util.UserValidateUtil;

@Builder
@Data
public class UserDto {
    @Size(max = 50, message = UserValidateUtil.NAME_SIZE)
    @NotBlank(message = UserValidateUtil.NAME_NOT_BLANK)
    @NotEmpty(message = UserValidateUtil.NAME_NOT_EMPTY)
    @NotNull(message = UserValidateUtil.NAME_NOT_NULL)
    private String name;

    @Size(max = 50, message = UserValidateUtil.LAST_NAME_SIZE)
    @NotBlank(message = UserValidateUtil.LAST_NAME_NOT_BLANK)
    @NotEmpty(message = UserValidateUtil.LAST_NAME_NOT_EMPTY)
    @NotNull(message = UserValidateUtil.LAST_NAME_NOT_NULL)
    private String lastName;

    @NotBlank(message = UserValidateUtil.DOCUMENT_TYPE_NOT_BLANK)
    @NotEmpty(message = UserValidateUtil.DOCUMENT_TYPE_NOT_EMPTY)
    @NotNull(message = UserValidateUtil.DOCUMENT_TYPE_NOT_NULL)
    @Pattern(regexp = UserValidateUtil.DOCUMENT_TYPE_REGEX, message = UserValidateUtil.DOCUMENT_TYPE_PATTERN)
    private String documentType;

    @NotBlank(message = UserValidateUtil.DOCUMENT_NUMBER_NOT_BLANK)
    @NotEmpty(message = UserValidateUtil.DOCUMENT_NUMBER_NOT_EMPTY)
    @NotNull(message = UserValidateUtil.DOCUMENT_NUMBER_NOT_NULL)
    private String documentNumber;

    @NotBlank(message = UserValidateUtil.PHONE_NOT_BLANK)
    @NotEmpty(message = UserValidateUtil.PHONE_NOT_EMPTY)
    @NotNull(message = UserValidateUtil.PHONE_NOT_NULL)
    @Pattern(regexp = UserValidateUtil.PHONE_REGEX, message = UserValidateUtil.PHONE_PATTERN)
    @Size(max = 15, message = UserValidateUtil.PHONE_SIZE)
    private String phone;

    @NotBlank(message = UserValidateUtil.EMAIL_NOT_BLANK)
    @NotEmpty(message = UserValidateUtil.EMAIL_NOT_EMPTY)
    @NotNull(message = UserValidateUtil.EMAIL_NOT_NULL)
    @Pattern(regexp = UserValidateUtil.EMAIL_REGEX, message = UserValidateUtil.EMAIL_PATTERN)
    @Size(max = 100, message = UserValidateUtil.EMAIL_SIZE)
    private String email;

    @NotBlank(message = UserValidateUtil.PASSWORD_NOT_BLANK)
    @NotEmpty(message = UserValidateUtil.PASSWORD_NOT_EMPTY)
    @NotNull(message = UserValidateUtil.PASSWORD_NOT_NULL)
    @Pattern(regexp = UserValidateUtil.PASSWORD_REGEX, message = UserValidateUtil.PASSWORD_PATTERN)
    private String password;

    private String verificationCode;

    private boolean enabled;
}
