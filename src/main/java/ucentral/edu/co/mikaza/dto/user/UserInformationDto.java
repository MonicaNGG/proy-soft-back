package ucentral.edu.co.mikaza.dto.user;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserInformationDto {
    private String email;
    private String verificationCode;
    private boolean enabled;
}
