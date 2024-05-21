package ucentral.edu.co.mikaza.mapper;

import ucentral.edu.co.mikaza.dto.property.CreatePropertyDto;
import ucentral.edu.co.mikaza.dto.property.GetPropertyDto;
import ucentral.edu.co.mikaza.dto.property.UpdatePropertyDto;
import ucentral.edu.co.mikaza.model.Property;

import java.util.List;

public class PropertyMapper {

    private PropertyMapper(){};
    public static GetPropertyDto modelToGetPropertyDto(Property property) {
        return GetPropertyDto.builder()
                .city(property.getCity())
                .zone(property.getZone())
                .price(property.getPrice())
                .entryDate(property.getEntryDate())
                .exitDate(property.getExitDate())
                .numberPeople(property.getNumberPeople())
                .accommodationType(property.getAccommodationType())
                .additionalServices(property.getAdditionalServices())
                .image(property.getImage())
                .build();
    }

    public static List<GetPropertyDto> modelToGetPropertyDtoList(List<Property> properties) {
        return properties.stream().map(PropertyMapper::modelToGetPropertyDto).toList();
    }

    public static CreatePropertyDto modelToCreatePropertyDto(Property property) {
        return CreatePropertyDto.builder()
                .city(property.getCity())
                .zone(property.getZone())
                .price(property.getPrice())
                .entryDate(property.getEntryDate())
                .exitDate(property.getExitDate())
                .numberPeople(property.getNumberPeople())
                .accommodationType(property.getAccommodationType())
                .additionalServices(property.getAdditionalServices())
                .image(property.getImage())
                .build();
    }

    public static Property createPropertyDtoToModel(CreatePropertyDto createPropertyDto) {
        return Property.builder()
                .city(createPropertyDto.getCity())
                .zone(createPropertyDto.getZone())
                .price(createPropertyDto.getPrice())
                .entryDate(createPropertyDto.getEntryDate())
                .exitDate(createPropertyDto.getExitDate())
                .numberPeople(createPropertyDto.getNumberPeople())
                .accommodationType(createPropertyDto.getAccommodationType())
                .additionalServices(createPropertyDto.getAdditionalServices())
                .image(createPropertyDto.getImage())
                .build();
    }

    public static Property updatePropertyDtoToModel(UpdatePropertyDto updatePropertyDto) {
        return Property.builder()
                .id(updatePropertyDto.getId())
                .city(updatePropertyDto.getCity())
                .zone(updatePropertyDto.getZone())
                .price(updatePropertyDto.getPrice())
                .entryDate(updatePropertyDto.getEntryDate())
                .exitDate(updatePropertyDto.getExitDate())
                .numberPeople(updatePropertyDto.getNumberPeople())
                .accommodationType(updatePropertyDto.getAccommodationType())
                .additionalServices(updatePropertyDto.getAdditionalServices())
                .image(updatePropertyDto.getImage())
                .build();
    }

    public static UpdatePropertyDto modelToUpdatePropertyDto(Property property) {
        return UpdatePropertyDto.builder()
                .id(property.getId())
                .city(property.getCity())
                .zone(property.getZone())
                .price(property.getPrice())
                .entryDate(property.getEntryDate())
                .exitDate(property.getExitDate())
                .numberPeople(property.getNumberPeople())
                .accommodationType(property.getAccommodationType())
                .additionalServices(property.getAdditionalServices())
                .image(property.getImage())
                .build();
    }

    public static Property getPropertyDtoToModel(GetPropertyDto getPropertyDto) {
        return Property.builder()
                .city(getPropertyDto.getCity())
                .zone(getPropertyDto.getZone())
                .price(getPropertyDto.getPrice())
                .entryDate(getPropertyDto.getEntryDate())
                .exitDate(getPropertyDto.getExitDate())
                .numberPeople(getPropertyDto.getNumberPeople())
                .accommodationType(getPropertyDto.getAccommodationType())
                .additionalServices(getPropertyDto.getAdditionalServices())
                .image(getPropertyDto.getImage())
                .build();
    }

    public static List<Property> getPropertyDtoToModelList(List<GetPropertyDto> getPropertiesDto) {
        return getPropertiesDto.stream().map(PropertyMapper::getPropertyDtoToModel).toList();
    }
}
