package ucentral.edu.co.mikaza.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ucentral.edu.co.mikaza.controller.PropertyController;
import ucentral.edu.co.mikaza.dto.property.GetPropertyDto;
import ucentral.edu.co.mikaza.exception.PropertyException;
import ucentral.edu.co.mikaza.service.PropertyService;
import ucentral.edu.co.mikaza.util.PropertyUtilTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PropertyControllerTest {
    @Autowired
    private PropertyController propertyController;

    @MockBean
    private PropertyService propertyService;

    @Test
    public void getAllPropertiesOk() {
        when(propertyService.getAllProperties(
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null
        )).thenReturn(PropertyUtilTest.PROPERTIES_DTO);

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
    public void getPropertyByIdTestOk() throws PropertyException {
        when(propertyService.getPropertyById(PropertyUtilTest.ID_ONE)).thenReturn(PropertyUtilTest.GET_PROPERTY_DTO_ONE);

        ResponseEntity<GetPropertyDto> response = propertyController.getPropertyById(PropertyUtilTest.ID_ONE);

        verify(propertyService).getPropertyById(eq(PropertyUtilTest.ID_ONE));

        assertEquals(HttpStatus.OK.value(), response.getStatusCode().value());
    }

    @Test
    public void savePropertyTestOk() {
        when(propertyService.saveProperty(PropertyUtilTest.CREATE_PROPERTY_DTO)).thenReturn(PropertyUtilTest.GET_PROPERTY_DTO_ONE);

        ResponseEntity<GetPropertyDto> response = propertyController.saveProperty(PropertyUtilTest.CREATE_PROPERTY_DTO);

        verify(propertyService).saveProperty(eq(PropertyUtilTest.CREATE_PROPERTY_DTO));

        assertEquals(HttpStatus.CREATED.value(), response.getStatusCode().value());
    }

    @Test
    public void updatePropertyTestOk() throws PropertyException {
        when(propertyService.updateProperty(PropertyUtilTest.UPDATE_PROPERTY_DTO)).thenReturn(PropertyUtilTest.GET_PROPERTY_DTO_ONE);

        ResponseEntity<GetPropertyDto> response = propertyController.updateProperty(PropertyUtilTest.UPDATE_PROPERTY_DTO);

        verify(propertyService).updateProperty(eq(PropertyUtilTest.UPDATE_PROPERTY_DTO));

        assertEquals(HttpStatus.OK.value(), response.getStatusCode().value());
    }

    @Test
    public void deletePropertyTestOk() throws PropertyException {
        when(propertyService.deleteProperty(PropertyUtilTest.ID_ONE)).thenReturn(PropertyUtilTest.PROPERTY_DELETED);

        ResponseEntity<String> response = propertyController.deleteProperty(PropertyUtilTest.ID_ONE);

        verify(propertyService).deleteProperty(eq(PropertyUtilTest.ID_ONE));

        assertEquals(HttpStatus.OK.value(), response.getStatusCode().value());
    }
}
