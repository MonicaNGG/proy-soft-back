package ucentral.edu.co.mikaza.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import ucentral.edu.co.mikaza.dto.property.GetPropertyDto;
import ucentral.edu.co.mikaza.exception.PropertyException;
import ucentral.edu.co.mikaza.repository.PropertyRepository;
import ucentral.edu.co.mikaza.service.implementation.PropertyServiceImpl;
import ucentral.edu.co.mikaza.util.PropertyUtilTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.List;

import static org.mockito.BDDMockito.given;

@SpringBootTest
public class PropertyServiceImplTest {
    @InjectMocks
    private PropertyServiceImpl propertyServiceImpl;

    @Mock
    private PropertyRepository propertyRepository;

    @Test
    public void createPropertyTestOk() {
        given(propertyRepository.save(PropertyUtilTest.PROPERTY_MODEL_THREE)).willReturn(PropertyUtilTest.PROPERTY_MODEL_THREE);

        GetPropertyDto getPropertyDto = propertyServiceImpl.saveProperty(PropertyUtilTest.CREATE_PROPERTY_DTO);

        assertEquals(PropertyUtilTest.CITY, getPropertyDto.getCity());
    }

    @Test
    public void getAllPropertiesOk() {
        given(propertyRepository.findAll()).willReturn(PropertyUtilTest.PROPERTIES_MODEL);

        List<GetPropertyDto> properties = propertyServiceImpl.getAllProperties(null, null, null, null, null, null, null, null);

        assertEquals(PropertyUtilTest.PROPERTIES_SIZE, properties.size());
    }

    @Test
    public void getPropertyByIdOk() throws PropertyException {
        given(propertyRepository.save(PropertyUtilTest.PROPERTY_MODEL_ONE)).willReturn(PropertyUtilTest.PROPERTY_MODEL_ONE);
        given(propertyRepository.existsById(PropertyUtilTest.ID_ONE)).willReturn(true);
        given(propertyRepository.getReferenceById(PropertyUtilTest.ID_ONE)).willReturn(PropertyUtilTest.PROPERTY_MODEL_ONE);

        GetPropertyDto getPropertyDto = propertyServiceImpl.getPropertyById(PropertyUtilTest.ID_ONE);

        assertEquals(PropertyUtilTest.CITY, getPropertyDto.getCity());
    }

    @Test
    public void updatePropertyOk() throws PropertyException {
        given(propertyRepository.save(PropertyUtilTest.PROPERTY_MODEL_ONE)).willReturn(PropertyUtilTest.PROPERTY_MODEL_ONE);
        given(propertyRepository.existsById(PropertyUtilTest.ID_ONE)).willReturn(true);

        GetPropertyDto getPropertyDto = propertyServiceImpl.updateProperty(PropertyUtilTest.UPDATE_PROPERTY_DTO);

        assertEquals(PropertyUtilTest.CITY, getPropertyDto.getCity());
    }

    @Test
    public void deletePropertyOk() throws PropertyException {
        given(propertyRepository.existsById(PropertyUtilTest.ID_ONE)).willReturn(true);

        String message = propertyServiceImpl.deleteProperty(PropertyUtilTest.ID_ONE);

        assertEquals(PropertyUtilTest.PROPERTY_DELETED, message);
    }
}
