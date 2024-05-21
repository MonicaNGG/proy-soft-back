package ucentral.edu.co.mikaza.util;

import ucentral.edu.co.mikaza.dto.property.CreatePropertyDto;
import ucentral.edu.co.mikaza.dto.property.GetPropertyDto;
import ucentral.edu.co.mikaza.dto.property.UpdatePropertyDto;
import ucentral.edu.co.mikaza.model.Property;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class PropertyUtilTest {
    public static Long ID_ONE = 1L;
    public static Long ID_TWO = 1L;
    public static String CITY = "Bogotá";
    public static String ZONE = "Norte";
    public static Integer PRICE = 1000000;
    public static Date ENTRY_DATE = new Date(31/12/2022);
    public static Date EXIT_DATE = new Date(01/01/2023);
    public static Short NUMBER_PEOPLE = 2;
    public static String ACCOMMODATION_TYPE = "Apartamento";
    public static String ADDITIONAL_SERVICES = "Wifi, TV, Cocina";
    public static Integer PROPERTIES_SIZE = 2;
    public static boolean PROPERTY_EXISTS = false;
    public static String PROPERTY_DELETED = "Propiedad con id 1 eliminada correctamente";

    public static CreatePropertyDto CREATE_PROPERTY_DTO = CreatePropertyDto.builder()
            .city(CITY)
            .zone(ZONE)
            .price(PRICE)
            .entryDate(ENTRY_DATE)
            .exitDate(EXIT_DATE)
            .numberPeople(NUMBER_PEOPLE)
            .accommodationType(ACCOMMODATION_TYPE)
            .build();

    public static UpdatePropertyDto UPDATE_PROPERTY_DTO = UpdatePropertyDto.builder()
            .id(ID_ONE)
            .city(CITY)
            .zone(ZONE)
            .price(PRICE)
            .entryDate(ENTRY_DATE)
            .exitDate(EXIT_DATE)
            .numberPeople(NUMBER_PEOPLE)
            .accommodationType(ACCOMMODATION_TYPE)
            .build();

    public static GetPropertyDto GET_PROPERTY_DTO_ONE = GetPropertyDto.builder()
            .city(CITY)
            .zone(ZONE)
            .price(PRICE)
            .entryDate(ENTRY_DATE)
            .exitDate(EXIT_DATE)
            .numberPeople(NUMBER_PEOPLE)
            .accommodationType(ACCOMMODATION_TYPE)
            .build();

    public static GetPropertyDto GET_PROPERTY_DTO_TWO = GetPropertyDto.builder()
            .city(CITY)
            .zone(ZONE)
            .price(PRICE)
            .entryDate(ENTRY_DATE)
            .exitDate(EXIT_DATE)
            .numberPeople(NUMBER_PEOPLE)
            .accommodationType(ACCOMMODATION_TYPE)
            .build();

    public static Property PROPERTY_MODEL_ONE = Property.builder()
            .id(ID_ONE)
            .city(CITY)
            .zone(ZONE)
            .price(PRICE)
            .entryDate(ENTRY_DATE)
            .exitDate(EXIT_DATE)
            .numberPeople(NUMBER_PEOPLE)
            .accommodationType(ACCOMMODATION_TYPE)
            .build();

    public static Property PROPERTY_MODEL_TWO = Property.builder()
            .id(ID_TWO)
            .city(CITY)
            .zone(ZONE)
            .price(PRICE)
            .entryDate(ENTRY_DATE)
            .exitDate(EXIT_DATE)
            .numberPeople(NUMBER_PEOPLE)
            .accommodationType(ACCOMMODATION_TYPE)
            .build();

    public static Property PROPERTY_MODEL_THREE = Property.builder()
            .city(CITY)
            .zone(ZONE)
            .price(PRICE)
            .entryDate(ENTRY_DATE)
            .exitDate(EXIT_DATE)
            .numberPeople(NUMBER_PEOPLE)
            .accommodationType(ACCOMMODATION_TYPE)
            .build();

    public static List<Property> PROPERTIES_MODEL = Arrays.asList(PROPERTY_MODEL_ONE, PROPERTY_MODEL_TWO);
    public static List<GetPropertyDto> PROPERTIES_DTO = Arrays.asList(GET_PROPERTY_DTO_ONE, GET_PROPERTY_DTO_TWO);
}
