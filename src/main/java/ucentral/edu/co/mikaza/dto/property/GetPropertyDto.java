package ucentral.edu.co.mikaza.dto.property;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class GetPropertyDto {
    private String city;
    private String zone;
    private Integer price;
    private Date entryDate;
    private Date exitDate;
    private Short numberPeople;
    private String accommodationType;
    private String additionalServices;
    private String image;
}
