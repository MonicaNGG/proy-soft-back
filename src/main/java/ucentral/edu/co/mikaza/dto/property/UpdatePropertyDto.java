package ucentral.edu.co.mikaza.dto.property;

import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;
import ucentral.edu.co.mikaza.util.PropertyValidateUtil;

import java.util.Date;

@Builder
@Data
public class UpdatePropertyDto {
    @NotNull(message = PropertyValidateUtil.ID_NOT_NULL)
    @Positive(message = PropertyValidateUtil.ID_NOT_NEGATIVE)
    private Long id;

    @NotBlank(message = PropertyValidateUtil.CITY_NOT_BLANK)
    @NotEmpty(message = PropertyValidateUtil.CITY_NOT_EMPTY)
    @NotNull(message = PropertyValidateUtil.CITY_NOT_NULL)
    @Size(max = 50, message = PropertyValidateUtil.CITY_SIZE)
    private String city;

    @NotBlank(message = PropertyValidateUtil.ZONE_NOT_BLANK)
    @NotEmpty(message = PropertyValidateUtil.ZONE_NOT_EMPTY)
    @NotNull(message = PropertyValidateUtil.ZONE_NOT_NULL)
    @Size(max = 50, message = PropertyValidateUtil.ZONE_SIZE)
    private String zone;

    @NotNull(message = PropertyValidateUtil.PRICE_NOT_NULL)
    @Positive(message = PropertyValidateUtil.PRICE_NOT_NEGATIVE)
    private Integer price;

    @NotNull(message = PropertyValidateUtil.ENTRY_DATE_NOT_NULL)
    @PastOrPresent(message = PropertyValidateUtil.ENTRY_DATE_BEFORE_NOW)
    private Date entryDate;

    @NotNull(message = PropertyValidateUtil.EXIT_DATE_NOT_NULL)
    @PastOrPresent(message = PropertyValidateUtil.EXIT_DATE_BEFORE_NOW)
    private Date exitDate;

    @NotNull(message = PropertyValidateUtil.NUMBER_PEOPLE_NOT_NULL)
    @Positive(message = PropertyValidateUtil.NUMBER_PEOPLE_NOT_NEGATIVE)
    private Short numberPeople;

    @NotBlank(message = PropertyValidateUtil.ACCOMMODATION_TYPE_NOT_BLANK)
    @NotEmpty(message = PropertyValidateUtil.ACCOMMODATION_TYPE_NOT_EMPTY)
    @NotNull(message = PropertyValidateUtil.ACCOMMODATION_TYPE_NOT_NULL)
    @Size(max = 50, message = PropertyValidateUtil.ACCOMMODATION_TYPE_SIZE)
    private String accommodationType;

    @NotBlank(message = PropertyValidateUtil.ADDITIONAL_SERVICES_NOT_BLANK)
    @NotEmpty(message = PropertyValidateUtil.ADDITIONAL_SERVICES_NOT_EMPTY)
    @NotNull(message = PropertyValidateUtil.ADDITIONAL_SERVICES_NOT_NULL)
    @Size(max = 100, message = PropertyValidateUtil.ADDITIONAL_SERVICES_SIZE)
    private String additionalServices;

    @NotBlank(message = PropertyValidateUtil.IMAGE_NOT_BLANK)
    @NotEmpty(message = PropertyValidateUtil.IMAGE_NOT_EMPTY)
    @NotNull(message = PropertyValidateUtil.IMAGE_NOT_NULL)
    @Size(max = 200, message = PropertyValidateUtil.IMAGE_SIZE)
    private String image;
}
