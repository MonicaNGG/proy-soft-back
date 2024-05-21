package ucentral.edu.co.mikaza.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ucentral.edu.co.mikaza.model.Property;

import java.util.Date;
import java.util.List;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {
    List<Property> findAllByCity(String city);
    List<Property> findAllByZone(String zone);
    List<Property> findAllByPrice(Integer price);
    List<Property> findAllByEntryDate(Date entryDate);
    List<Property> findAllByExitDate(Date exitDate);
    List<Property> findAllByNumberPeople(Short numberPeople);
    List<Property> findAllByAccommodationType(String accommodationType);
    List<Property> findAllByAdditionalServices(String additionalServices);
}
