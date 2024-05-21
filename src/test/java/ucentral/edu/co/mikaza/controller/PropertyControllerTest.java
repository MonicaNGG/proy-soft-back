package ucentral.edu.co.mikaza.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ucentral.edu.co.mikaza.dto.property.GetPropertyDto;
import ucentral.edu.co.mikaza.exception.PropertyException;
import ucentral.edu.co.mikaza.service.PropertyService;
import ucentral.edu.co.mikaza.util.PropertyUtil;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
 class PropertyControllerTest {
    @Autowired
    private PropertyController propertyController;

    @MockBean
    private PropertyService propertyService;

    @Test
     void getAllPropertiesOk() {
        when(propertyService.getAllProperties(
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null
        )).thenReturn(PropertyUtil.PROPERTIES_DTO);

        ResponseEntity<List<GetPropertyDto>> response = propertyController.getAllProperties(
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null
        );

        verify(propertyService).getAllProperties(
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null
        );

        assertEquals(HttpStatus.OK.value(), response.getStatusCode().value());
    }

    @Test
     void getPropertyByIdTestOk() throws PropertyException {
        when(propertyService.getPropertyById(PropertyUtil.ID_ONE)).thenReturn(PropertyUtil.GET_PROPERTY_DTO_ONE);

        ResponseEntity<GetPropertyDto> response = propertyController.getPropertyById(PropertyUtil.ID_ONE);

        verify(propertyService).getPropertyById(PropertyUtil.ID_ONE);

        assertEquals(HttpStatus.OK.value(), response.getStatusCode().value());
    }

    @Test
     void savePropertyTestOk() {
        when(propertyService.saveProperty(PropertyUtil.CREATE_PROPERTY_DTO)).thenReturn(PropertyUtil.GET_PROPERTY_DTO_ONE);

        ResponseEntity<GetPropertyDto> response = propertyController.saveProperty(PropertyUtil.CREATE_PROPERTY_DTO);

        verify(propertyService).saveProperty(PropertyUtil.CREATE_PROPERTY_DTO);

        assertEquals(HttpStatus.CREATED.value(), response.getStatusCode().value());
    }

    @Test
     void updatePropertyTestOk() throws PropertyException {
        when(propertyService.updateProperty(PropertyUtil.UPDATE_PROPERTY_DTO)).thenReturn(PropertyUtil.GET_PROPERTY_DTO_ONE);

        ResponseEntity<GetPropertyDto> response = propertyController.updateProperty(PropertyUtil.UPDATE_PROPERTY_DTO);

        verify(propertyService).updateProperty(PropertyUtil.UPDATE_PROPERTY_DTO);

        assertEquals(HttpStatus.OK.value(), response.getStatusCode().value());
    }

    @Test
     void deletePropertyTestOk() throws PropertyException {
        when(propertyService.deleteProperty(PropertyUtil.ID_ONE)).thenReturn(PropertyUtil.PROPERTY_DELETED);

        ResponseEntity<String> response = propertyController.deleteProperty(PropertyUtil.ID_ONE);

        verify(propertyService).deleteProperty(PropertyUtil.ID_ONE);

        assertEquals(HttpStatus.OK.value(), response.getStatusCode().value());
    }
}
