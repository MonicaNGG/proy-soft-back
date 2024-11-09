package ucentral.edu.co.mikaza.service.implementation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ucentral.edu.co.mikaza.dto.property.CreatePropertyDto;
import ucentral.edu.co.mikaza.dto.property.GetPropertyDto;
import ucentral.edu.co.mikaza.dto.property.UpdatePropertyDto;
import ucentral.edu.co.mikaza.exception.PropertyException;
import ucentral.edu.co.mikaza.mapper.PropertyMapper;
import ucentral.edu.co.mikaza.model.Property;
import ucentral.edu.co.mikaza.model.User;
import ucentral.edu.co.mikaza.repository.PropertyRepository;
import ucentral.edu.co.mikaza.repository.UserRepository;
import ucentral.edu.co.mikaza.service.PropertyService;
import ucentral.edu.co.mikaza.util.PropertyValidateUtil;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Service
public class PropertyServiceImpl implements PropertyService {
    private final PropertyRepository propertyRepository;
    private final UserRepository userRepository;

    @Override
    public List<GetPropertyDto> getAllProperties(
            String city,
            String zone,
            Integer price,
            Date entryDate,
            Date exitDate,
            Short numberPeople,
            String accommodationType,
            String additionalServices
    ) {
        List<GetPropertyDto> filteredProperties = PropertyMapper.modelToGetPropertyDtoList(propertyRepository.findAll());

        if (city != null) filteredProperties = filterByCity(city);
        if (zone != null) filteredProperties = filterByZone(zone);
        if (price != null) filteredProperties = filterByPrice(price);
        if (entryDate != null) filteredProperties = filterByEntryDate(entryDate);
        if (exitDate != null) filteredProperties = filterByExitDate(exitDate);
        if (numberPeople != null) filteredProperties = filterByNumberPeople(numberPeople);
        if (accommodationType != null) filteredProperties = filterByAccommodationType(accommodationType);
        if (additionalServices != null) filteredProperties = filterByAdditionalServices(additionalServices);

        return filteredProperties;
    }

    private List<GetPropertyDto> filterByCity(String city) {
        return PropertyMapper.modelToGetPropertyDtoList(propertyRepository.findAllByCity(city));
    }

    private List<GetPropertyDto> filterByZone(String zone) {
        return PropertyMapper.modelToGetPropertyDtoList(propertyRepository.findAllByZone(zone));
    }

    private List<GetPropertyDto> filterByPrice(Integer price) {
        return PropertyMapper.modelToGetPropertyDtoList(propertyRepository.findAllByPrice(price));
    }

    private List<GetPropertyDto> filterByEntryDate(Date entryDate) {
        return PropertyMapper.modelToGetPropertyDtoList(propertyRepository.findAllByEntryDate(entryDate));
    }

    private List<GetPropertyDto> filterByExitDate(Date exitDate) {
        return PropertyMapper.modelToGetPropertyDtoList(propertyRepository.findAllByExitDate(exitDate));
    }

    private List<GetPropertyDto> filterByNumberPeople(Short numberPeople) {
        return PropertyMapper.modelToGetPropertyDtoList(propertyRepository.findAllByNumberPeople(numberPeople));
    }

    private List<GetPropertyDto> filterByAccommodationType(String accommodationType) {
        return PropertyMapper.modelToGetPropertyDtoList(propertyRepository.findAllByAccommodationType(accommodationType));
    }

    private List<GetPropertyDto> filterByAdditionalServices(String additionalServices) {
        return PropertyMapper.modelToGetPropertyDtoList(propertyRepository.findAllByAdditionalServices(additionalServices));
    }

    @Override
    public GetPropertyDto getPropertyById(Long id) throws PropertyException {
        if (!propertyRepository.existsById(id)) throw new PropertyException(PropertyValidateUtil.PROPERTY_NOT_FOUND);

        return PropertyMapper.modelToGetPropertyDto(propertyRepository.getReferenceById(id));
    }

    @Override
    public GetPropertyDto saveProperty(CreatePropertyDto createPropertyDto) {

        User user = userRepository.findById(createPropertyDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Property property = PropertyMapper.createPropertyDtoToModel(createPropertyDto);

        property.setUser(user);

        boolean isOwner = userRepository.existsById(user.getId());
        property.setIsOwner(isOwner);

        return PropertyMapper.modelToGetPropertyDto(propertyRepository.save(property));
    }

    @Override
    public GetPropertyDto updateProperty(UpdatePropertyDto updatePropertyDto) throws PropertyException {
        if (!propertyRepository.existsById(updatePropertyDto.getId())) throw new PropertyException(PropertyValidateUtil.PROPERTY_NOT_FOUND);

        return PropertyMapper.modelToGetPropertyDto(propertyRepository.save(PropertyMapper.updatePropertyDtoToModel(updatePropertyDto)));
    }

    @Override
    public String deleteProperty(Long id) throws PropertyException {
        if (!propertyRepository.existsById(id)) throw new PropertyException(PropertyValidateUtil.PROPERTY_NOT_FOUND);

        propertyRepository.deleteById(id);

        return String.format(PropertyValidateUtil.PROPERTY_DELETED, id);
    }
}
