package ucentral.edu.co.mikaza.util;

import ucentral.edu.co.mikaza.dto.user.LoginDto;
import ucentral.edu.co.mikaza.dto.user.UserDto;
import ucentral.edu.co.mikaza.dto.user.UserInformationDto;
import ucentral.edu.co.mikaza.model.User;

public class UserUtil {

    private UserUtil(){};

    public static String NAME = "John";
    public static String NAME_NOT_NULL = "Nombre no puede ser nulo";
    public static String LAST_NAME = "Doe";
    public static String DOCUMENT_NUMBER = "123456789";
    public static String DOCUMENT_NUMBER_UNIQUE = "El número de documento ya existe";
    public static String DOCUMENT_TYPE = "Cedula Ciudadania";
    public static String PHONE = "+57123456789";
    public static String EMAIL = "johndoe@example.com";
    public static String EMAIL_UNIQUE = "El correo electrónico ya existe";
    public static String EMAIL_NOT_FOUND = "Correo electrónico no encontrado";
    public static String EMAIL_NOT_VERIFIED = "Correo electrónico no verificado";
    public static String PASSWORD = "Johndoe123*";
    public static String PASSWORD_TWO = "Johndoe123";
    public static String PASSWORD_INCORRECT = "Contraseña incorrecta";
    public static String VERIFICATION_CODE = "123456";
    public static boolean ENABLED_TRUE = true;
    public static boolean ENABLED_FALSE = false;
    public static String EMAIL_VERIFIED_TEMPLATE = "email-verified";
    public static String EMAIL_NOT_VERIFIED_TEMPLATE = "email-not-verified";

    public static UserDto USER_DTO = UserDto.builder()
            .name(NAME)
            .lastName(LAST_NAME)
            .documentNumber(DOCUMENT_NUMBER)
            .documentType(DOCUMENT_TYPE)
            .phone(PHONE)
            .email(EMAIL)
            .password(PASSWORD)
            .build();

    public static UserDto USER_DTO_INCORRECT = UserDto.builder()
            .name(null)
            .lastName(LAST_NAME)
            .documentNumber(DOCUMENT_NUMBER)
            .documentType(DOCUMENT_TYPE)
            .phone(PHONE)
            .email(EMAIL)
            .password(PASSWORD_TWO)
            .build();

    public static User USER_MODEL = User.builder()
            .name(NAME)
            .lastName(LAST_NAME)
            .documentNumber(DOCUMENT_NUMBER)
            .documentType(DOCUMENT_TYPE)
            .phone(PHONE)
            .email(EMAIL)
            .password(PASSWORD)
            .build();

    public static User USER_MODEL_ENABLED = User.builder()
            .name(NAME)
            .lastName(LAST_NAME)
            .documentNumber(DOCUMENT_NUMBER)
            .documentType(DOCUMENT_TYPE)
            .phone(PHONE)
            .email(EMAIL)
            .password(PASSWORD)
            .verificationCode(VERIFICATION_CODE)
            .enabled(ENABLED_TRUE)
            .build();

    public static User USER_MODEL_NOT_ENABLED = User.builder()
            .name(NAME)
            .lastName(LAST_NAME)
            .documentNumber(DOCUMENT_NUMBER)
            .documentType(DOCUMENT_TYPE)
            .phone(PHONE)
            .email(EMAIL)
            .password(PASSWORD)
            .verificationCode(VERIFICATION_CODE)
            .enabled(ENABLED_FALSE)
            .build();

    public static LoginDto LOGIN_DTO = LoginDto.builder()
            .email(EMAIL)
            .password(PASSWORD)
            .build();

    public static LoginDto LOGIN_DTO_INCORRECT = LoginDto.builder()
            .email(EMAIL)
            .password(PASSWORD_TWO)
            .build();

    public static UserInformationDto USER_INFORMATION_DTO = UserInformationDto.builder()
            .email(EMAIL)
            .verificationCode(VERIFICATION_CODE)
            .enabled(ENABLED_TRUE)
            .build();
}
