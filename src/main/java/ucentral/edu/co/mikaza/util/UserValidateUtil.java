package ucentral.edu.co.mikaza.util;

public class UserValidateUtil {

    private UserValidateUtil(){};
    public static final String NAME_NOT_NULL = "Nombre no puede ser nulo";
    public static final String NAME_NOT_EMPTY = "Nombre no puede ser vacío";
    public static final String NAME_NOT_BLANK = "Nombre no puede estar en blanco";
    public static final String NAME_SIZE = "Nombre debe tener máximo 50 caracteres";

    public static final String LAST_NAME_NOT_NULL = "Apellido no puede ser nulo";
    public static final String LAST_NAME_NOT_EMPTY = "Apellido no puede ser vacío";
    public static final String LAST_NAME_NOT_BLANK = "Apellido no puede estar en blanco";
    public static final String LAST_NAME_SIZE = "Apellido debe tener máximo 50 caracteres";

    public static final String DOCUMENT_TYPE_NOT_NULL = "Tipo de documento no puede ser nulo";
    public static final String DOCUMENT_TYPE_NOT_EMPTY = "Tipo de documento no puede ser vacío";
    public static final String DOCUMENT_TYPE_NOT_BLANK = "Tipo de documento no puede estar en blanco";
    public static final String DOCUMENT_TYPE_PATTERN = "El tipo de documento debe ser Cédula de Ciudadanía, Cédula de Extranjería, Tarjeta de Identidad o Pasaporte";
    public static final String DOCUMENT_TYPE_REGEX = "Cedula Ciudadania|Cedula Extranjeria|Tarjeta Identidad|Pasaporte";

    public static final String DOCUMENT_NUMBER_NOT_NULL = "Número de documento no puede ser nulo";
    public static final String DOCUMENT_NUMBER_NOT_EMPTY = "Número de documento no puede ser vacío";
    public static final String DOCUMENT_NUMBER_NOT_BLANK = "Número de documento no puede estar en blanco";
    public static final String DOCUMENT_NUMBER_UNIQUE = "El número de documento ya existe";

    public static final String PHONE_NOT_NULL = "Teléfono no puede ser nulo";
    public static final String PHONE_NOT_EMPTY = "Teléfono no puede ser vacío";
    public static final String PHONE_NOT_BLANK = "Teléfono no puede estar en blanco";
    public static final String PHONE_PATTERN = "El teléfono debe comenzar con +57 y tener 10 dígitos";
    public static final String PHONE_REGEX = "^\\+57\\d{10}$";
    public static final String PHONE_SIZE = "El teléfono debe tener menos de 15 caracteres";

    public static final String EMAIL_NOT_NULL = "Correo electrónico no puede ser nulo";
    public static final String EMAIL_NOT_EMPTY = "Correo electrónico no puede ser vacío";
    public static final String EMAIL_NOT_BLANK = "Correo electrónico no puede estar en blanco";
    public static final String EMAIL_PATTERN = "El correo electrónico debe ser una dirección de correo válida";
    public static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    public static final String EMAIL_SIZE = "El correo electrónico debe tener menos de 100 caracteres";
    public static final String EMAIL_UNIQUE = "El correo electrónico ya existe";

    public static final String PASSWORD_NOT_NULL = "Contraseña no puede ser nula";
    public static final String PASSWORD_NOT_EMPTY = "Contraseña no puede ser vacía";
    public static final String PASSWORD_NOT_BLANK = "Contraseña no puede estar en blanco";
    public static final String PASSWORD_PATTERN = "La contraseña debe tener al menos 8 caracteres, una letra mayúscula, una letra minúscula y un número";
    public static final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-zA-Z]).{8,}";

    public static final String EMAIL_NOT_FOUND = "Correo electrónico no encontrado";
    public static final String EMAIL_NOT_VERIFIED = "Correo electrónico no verificado";
    public static final String PASSWORD_INCORRECT = "Contraseña incorrecta";

}
