package ucentral.edu.co.mikaza.util;

public class PropertyValidateUtil {

    public static final String USER_ID_NOT_NULL = "El ID del usuario es obligatorio.";

    public static final String PROPERTY_NOT_FOUND = "Propiedad no encontrada";
    public static final String PROPERTY_DELETED = "Propiedad con id %s eliminada correctamente";

    public static final String ID_NOT_NULL = "El id no puede ser nulo";
    public static final String ID_NOT_NEGATIVE = "El id no puede ser negativo";

    public static final String CITY_NOT_NULL = "La ciudad no puede ser nula";
    public static final String CITY_NOT_EMPTY = "La ciudad no puede ser vacía";
    public static final String CITY_NOT_BLANK = "La ciudad no puede estar en blanco";
    public static final String CITY_SIZE = "La ciudad debe tener máximo 50 caracteres";

    public static final String ZONE_NOT_NULL = "La zona no puede ser nula";
    public static final String ZONE_NOT_EMPTY = "La zona no puede ser vacía";
    public static final String ZONE_NOT_BLANK = "La zona no puede estar en blanco";
    public static final String ZONE_SIZE = "La zona debe tener máximo 50 caracteres";

    public static final String PRICE_NOT_NULL = "El precio no puede ser nulo";
    public static final String PRICE_NOT_NEGATIVE = "El precio no puede ser negativo o cero";

    public static final String ENTRY_DATE_NOT_NULL = "La fecha de entrada no puede ser nula";
    public static final String ENTRY_DATE_BEFORE_NOW = "La fecha de entrada no puede ser posterior a la fecha actual";

    public static final String EXIT_DATE_NOT_NULL = "La fecha de salida no puede ser nula";
    public static final String EXIT_DATE_BEFORE_NOW = "La fecha de salida no puede ser posterior a la fecha actual";

    public static final String NUMBER_PEOPLE_NOT_NULL = "El número de personas no puede ser nulo";
    public static final String NUMBER_PEOPLE_NOT_NEGATIVE = "El número de personas no puede ser negativo";

    public static final String ACCOMMODATION_TYPE_NOT_NULL = "El tipo de alojamiento no puede ser nulo";
    public static final String ACCOMMODATION_TYPE_NOT_EMPTY = "El tipo de alojamiento no puede ser vacío";
    public static final String ACCOMMODATION_TYPE_NOT_BLANK = "El tipo de alojamiento no puede estar en blanco";
    public static final String ACCOMMODATION_TYPE_SIZE = "El tipo de alojamiento debe tener máximo 50 caracteres";

    public static final String ADDITIONAL_SERVICES_NOT_NULL = "Los servicios adicionales no pueden ser nulos";
    public static final String ADDITIONAL_SERVICES_NOT_EMPTY = "Los servicios adicionales no pueden ser vacíos";
    public static final String ADDITIONAL_SERVICES_NOT_BLANK = "Los servicios adicionales no pueden estar en blanco";
    public static final String ADDITIONAL_SERVICES_SIZE = "Los servicios adicionales deben tener máximo 100 caracteres";

    public static final String IMAGE_NOT_NULL = "La imagen no puede ser nula";
    public static final String IMAGE_NOT_EMPTY = "La imagen no puede ser vacía";
    public static final String IMAGE_NOT_BLANK = "La imagen no puede estar en blanco";
    public static final String IMAGE_SIZE = "La imagen debe tener máximo 200 caracteres";
}
