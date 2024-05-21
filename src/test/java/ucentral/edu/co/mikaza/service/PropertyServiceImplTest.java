package ucentral.edu.co.mikaza.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import ucentral.edu.co.mikaza.dto.property.GetPropertyDto;
import ucentral.edu.co.mikaza.exception.PropertyException;
import ucentral.edu.co.mikaza.repository.PropertyRepository;
import ucentral.edu.co.mikaza.service.implementation.PropertyServiceImpl;
import ucentral.edu.co.mikaza.util.PropertyUtil;

import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.List;

import static org.mockito.BDDMockito.given;

@SpringBootTest
 class PropertyServiceImplTest {
    @InjectMocks
    private PropertyServiceImpl propertyServiceImpl;

    @Mock
    private PropertyRepository propertyRepository;

    @Test
     void createPropertyTestOk() {
        given(propertyRepository.save(PropertyUtil.PROPERTY_MODEL_THREE)).willReturn(PropertyUtil.PROPERTY_MODEL_THREE);

        GetPropertyDto getPropertyDto = propertyServiceImpl.saveProperty(PropertyUtil.CREATE_PROPERTY_DTO);

        assertEquals(PropertyUtil.CITY, getPropertyDto.getCity());
    }

    @Test
     void getAllPropertiesOk() {
        given(propertyRepository.findAll()).willReturn(PropertyUtil.PROPERTIES_MODEL);

        List<GetPropertyDto> properties = propertyServiceImpl.getAllProperties(null, null, null, null, null, null, null, null);

        assertEquals(PropertyUtil.PROPERTIES_SIZE, properties.size());
    }

    @Test
     void getPropertyByIdOk() throws PropertyException {
        given(propertyRepository.save(PropertyUtil.PROPERTY_MODEL_ONE)).willReturn(PropertyUtil.PROPERTY_MODEL_ONE);
        given(propertyRepository.existsById(PropertyUtil.ID_ONE)).willReturn(true);
        given(propertyRepository.getReferenceById(PropertyUtil.ID_ONE)).willReturn(PropertyUtil.PROPERTY_MODEL_ONE);

        GetPropertyDto getPropertyDto = propertyServiceImpl.getPropertyById(PropertyUtil.ID_ONE);

        assertEquals(PropertyUtil.CITY, getPropertyDto.getCity());
    }

    @Test
     void updatePropertyOk() throws PropertyException {
        given(propertyRepository.save(PropertyUtil.PROPERTY_MODEL_ONE)).willReturn(PropertyUtil.PROPERTY_MODEL_ONE);
        given(propertyRepository.existsById(PropertyUtil.ID_ONE)).willReturn(true);

        GetPropertyDto getPropertyDto = propertyServiceImpl.updateProperty(PropertyUtil.UPDATE_PROPERTY_DTO);

        assertEquals(PropertyUtil.CITY, getPropertyDto.getCity());
    }

    @Test
     void deletePropertyOk() throws PropertyException {
        given(propertyRepository.existsById(PropertyUtil.ID_ONE)).willReturn(true);

        String message = propertyServiceImpl.deleteProperty(PropertyUtil.ID_ONE);

        assertEquals(PropertyUtil.PROPERTY_DELETED, message);
    }
}
