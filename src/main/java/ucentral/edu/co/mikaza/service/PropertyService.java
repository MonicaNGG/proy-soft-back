package ucentral.edu.co.mikaza.service;

import ucentral.edu.co.mikaza.dto.property.CreatePropertyDto;
import ucentral.edu.co.mikaza.dto.property.GetPropertyDto;
import ucentral.edu.co.mikaza.dto.property.UpdatePropertyDto;
import ucentral.edu.co.mikaza.exception.PropertyException;

import java.util.Date;
import java.util.List;

public interface PropertyService {
    List<GetPropertyDto> getAllProperties(String city, String zone, Integer price, Date entryDate, Date exitDate, Short numberPeople, String accommodationType, String additionalServices);
    GetPropertyDto getPropertyById(Long id) throws PropertyException;
    GetPropertyDto saveProperty(CreatePropertyDto createPropertyDto);
    GetPropertyDto updateProperty(UpdatePropertyDto updatePropertyDto) throws PropertyException;
    String deleteProperty(Long id) throws PropertyException;
}
