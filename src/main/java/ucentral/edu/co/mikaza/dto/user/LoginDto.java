package ucentral.edu.co.mikaza.dto.user;

import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;
import ucentral.edu.co.mikaza.util.UserValidateUtil;

@Builder
@Data
public class LoginDto {
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
}
