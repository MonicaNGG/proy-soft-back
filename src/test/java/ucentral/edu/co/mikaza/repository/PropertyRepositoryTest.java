package ucentral.edu.co.mikaza.repository;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import ucentral.edu.co.mikaza.model.Property;
import ucentral.edu.co.mikaza.repository.PropertyRepository;
import ucentral.edu.co.mikaza.util.PropertyUtilTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.BDDMockito.given;

@SpringBootTest
public class PropertyRepositoryTest {
    @Mock
    private PropertyRepository propertyRepository;

    @Test
    public void saveUserTest() {
        given(propertyRepository.save(PropertyUtilTest.PROPERTY_MODEL_ONE)).willReturn(PropertyUtilTest.PROPERTY_MODEL_ONE);

        Property property = propertyRepository.save(PropertyUtilTest.PROPERTY_MODEL_ONE);

        assertNotNull(property);
    }

    @Test
    public void getReferenceByIdTest() {
        given(propertyRepository.getReferenceById(PropertyUtilTest.ID_ONE)).willReturn(PropertyUtilTest.PROPERTY_MODEL_ONE);

        Property property = propertyRepository.getReferenceById(PropertyUtilTest.ID_ONE);

        assertNotNull(property);
    }

    @Test
    public void existsByIdTest() {
        given(propertyRepository.existsById(PropertyUtilTest.ID_ONE)).willReturn(true);

        boolean exists = propertyRepository.existsById(PropertyUtilTest.ID_ONE);

        assertNotNull(exists);
    }

    @Test
    public void deleteByIdTest() {
        propertyRepository.deleteById(PropertyUtilTest.ID_ONE);

        boolean exists = propertyRepository.existsById(PropertyUtilTest.ID_ONE);

        assertEquals(PropertyUtilTest.PROPERTY_EXISTS, exists);
    }

    @Test
    public void findAllTest() {
        given(propertyRepository.findAll()).willReturn(PropertyUtilTest.PROPERTIES_MODEL);

        assertNotNull(propertyRepository.findAll());
    }

    @Test
    public void findAllByCityTest() {
        given(propertyRepository.findAllByCity(PropertyUtilTest.CITY)).willReturn(PropertyUtilTest.PROPERTIES_MODEL);

        assertNotNull(propertyRepository.findAllByCity(PropertyUtilTest.CITY));
    }

    @Test
    public void findAllByZoneTest() {
        given(propertyRepository.findAllByZone(PropertyUtilTest.ZONE)).willReturn(PropertyUtilTest.PROPERTIES_MODEL);

        assertNotNull(propertyRepository.findAllByZone(PropertyUtilTest.ZONE));
    }

    @Test
    public void findAllByPriceTest() {
        given(propertyRepository.findAllByPrice(PropertyUtilTest.PRICE)).willReturn(PropertyUtilTest.PROPERTIES_MODEL);

        assertNotNull(propertyRepository.findAllByPrice(PropertyUtilTest.PRICE));
    }

    @Test
    public void findAllByEntryDateTest() {
        given(propertyRepository.findAllByEntryDate(PropertyUtilTest.ENTRY_DATE)).willReturn(PropertyUtilTest.PROPERTIES_MODEL);

        assertNotNull(propertyRepository.findAllByEntryDate(PropertyUtilTest.ENTRY_DATE));
    }

    @Test
    public void findAllByExitDateTest() {
        given(propertyRepository.findAllByExitDate(PropertyUtilTest.EXIT_DATE)).willReturn(PropertyUtilTest.PROPERTIES_MODEL);

        assertNotNull(propertyRepository.findAllByExitDate(PropertyUtilTest.EXIT_DATE));
    }

    @Test
    public void findAllByNumberPeopleTest() {
        given(propertyRepository.findAllByNumberPeople(PropertyUtilTest.NUMBER_PEOPLE)).willReturn(PropertyUtilTest.PROPERTIES_MODEL);

        assertNotNull(propertyRepository.findAllByNumberPeople(PropertyUtilTest.NUMBER_PEOPLE));
    }

    @Test
    public void findAllByAccommodationTypeTest() {
        given(propertyRepository.findAllByAccommodationType(PropertyUtilTest.ACCOMMODATION_TYPE)).willReturn(PropertyUtilTest.PROPERTIES_MODEL);

        assertNotNull(propertyRepository.findAllByAccommodationType(PropertyUtilTest.ACCOMMODATION_TYPE));
    }

    @Test
    public void findAllByAdditionalServicesTest() {
        given(propertyRepository.findAllByAdditionalServices(PropertyUtilTest.ADDITIONAL_SERVICES)).willReturn(PropertyUtilTest.PROPERTIES_MODEL);

        assertNotNull(propertyRepository.findAllByAdditionalServices(PropertyUtilTest.ADDITIONAL_SERVICES));
    }
}
