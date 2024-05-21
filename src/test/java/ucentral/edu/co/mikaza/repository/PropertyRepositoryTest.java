package ucentral.edu.co.mikaza.repository;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import ucentral.edu.co.mikaza.model.Property;
import ucentral.edu.co.mikaza.util.PropertyUtil;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.BDDMockito.given;

@SpringBootTest
 class PropertyRepositoryTest {
    @Mock
    private PropertyRepository propertyRepository;

    @Test
     void saveUserTest() {
        given(propertyRepository.save(PropertyUtil.PROPERTY_MODEL_ONE)).willReturn(PropertyUtil.PROPERTY_MODEL_ONE);

        Property property = propertyRepository.save(PropertyUtil.PROPERTY_MODEL_ONE);

        assertNotNull(property);
    }

    @Test
     void getReferenceByIdTest() {
        given(propertyRepository.getReferenceById(PropertyUtil.ID_ONE)).willReturn(PropertyUtil.PROPERTY_MODEL_ONE);

        Property property = propertyRepository.getReferenceById(PropertyUtil.ID_ONE);

        assertNotNull(property);
    }

    @Test
     void existsByIdTest() {
        given(propertyRepository.existsById(PropertyUtil.ID_ONE)).willReturn(true);

        boolean exists = propertyRepository.existsById(PropertyUtil.ID_ONE);

        assertEquals(exists, true);
    }

    @Test
     void deleteByIdTest() {
        propertyRepository.deleteById(PropertyUtil.ID_ONE);

        boolean exists = propertyRepository.existsById(PropertyUtil.ID_ONE);

        assertEquals(PropertyUtil.PROPERTY_EXISTS, exists);
    }

    @Test
     void findAllTest() {
        given(propertyRepository.findAll()).willReturn(PropertyUtil.PROPERTIES_MODEL);

        assertNotNull(propertyRepository.findAll());
    }

    @Test
     void findAllByCityTest() {
        given(propertyRepository.findAllByCity(PropertyUtil.CITY)).willReturn(PropertyUtil.PROPERTIES_MODEL);

        assertNotNull(propertyRepository.findAllByCity(PropertyUtil.CITY));
    }

    @Test
     void findAllByZoneTest() {
        given(propertyRepository.findAllByZone(PropertyUtil.ZONE)).willReturn(PropertyUtil.PROPERTIES_MODEL);

        assertNotNull(propertyRepository.findAllByZone(PropertyUtil.ZONE));
    }

    @Test
     void findAllByPriceTest() {
        given(propertyRepository.findAllByPrice(PropertyUtil.PRICE)).willReturn(PropertyUtil.PROPERTIES_MODEL);

        assertNotNull(propertyRepository.findAllByPrice(PropertyUtil.PRICE));
    }

    @Test
     void findAllByEntryDateTest() {
        given(propertyRepository.findAllByEntryDate(PropertyUtil.ENTRY_DATE)).willReturn(PropertyUtil.PROPERTIES_MODEL);

        assertNotNull(propertyRepository.findAllByEntryDate(PropertyUtil.ENTRY_DATE));
    }

    @Test
     void findAllByExitDateTest() {
        given(propertyRepository.findAllByExitDate(PropertyUtil.EXIT_DATE)).willReturn(PropertyUtil.PROPERTIES_MODEL);

        assertNotNull(propertyRepository.findAllByExitDate(PropertyUtil.EXIT_DATE));
    }

    @Test
     void findAllByNumberPeopleTest() {
        given(propertyRepository.findAllByNumberPeople(PropertyUtil.NUMBER_PEOPLE)).willReturn(PropertyUtil.PROPERTIES_MODEL);

        assertNotNull(propertyRepository.findAllByNumberPeople(PropertyUtil.NUMBER_PEOPLE));
    }

    @Test
     void findAllByAccommodationTypeTest() {
        given(propertyRepository.findAllByAccommodationType(PropertyUtil.ACCOMMODATION_TYPE)).willReturn(PropertyUtil.PROPERTIES_MODEL);

        assertNotNull(propertyRepository.findAllByAccommodationType(PropertyUtil.ACCOMMODATION_TYPE));
    }

    @Test
     void findAllByAdditionalServicesTest() {
        given(propertyRepository.findAllByAdditionalServices(PropertyUtil.ADDITIONAL_SERVICES)).willReturn(PropertyUtil.PROPERTIES_MODEL);

        assertNotNull(propertyRepository.findAllByAdditionalServices(PropertyUtil.ADDITIONAL_SERVICES));
    }
}
