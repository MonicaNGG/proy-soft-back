package ucentral.edu.co.mikaza.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ucentral.edu.co.mikaza.dto.common.MessageDto;
import ucentral.edu.co.mikaza.dto.property.CreatePropertyDto;
import ucentral.edu.co.mikaza.dto.property.GetPropertyDto;
import ucentral.edu.co.mikaza.dto.property.UpdatePropertyDto;
import ucentral.edu.co.mikaza.exception.PropertyException;
import ucentral.edu.co.mikaza.service.PropertyService;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@RequestMapping("/api/property")
@RestController
@Slf4j
@CrossOrigin(origins = "*", methods = { RequestMethod.DELETE, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT })
public class PropertyController {
    private final PropertyService propertyService;

    @GetMapping(path = "/getAllProperties")
    public ResponseEntity<List<GetPropertyDto>> getAllProperties(
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String zone,
            @RequestParam(required = false) Integer price,
            @RequestParam(required = false) Date entryDate,
            @RequestParam(required = false) Date exitDate,
            @RequestParam(required = false) Short numberPeople,
            @RequestParam(required = false) String accommodationType,
            @RequestParam(required = false) String additionalServices
    ) {
        return new ResponseEntity(propertyService.getAllProperties(
                city,
                zone,
                price,
                entryDate,
                exitDate,
                numberPeople,
                accommodationType,
                additionalServices
        ), HttpStatus.OK);
    }

    @GetMapping(path = "/getPropertyById/{id}")
    public ResponseEntity<GetPropertyDto> getPropertyById(@PathVariable Long id) throws PropertyException {
        return new ResponseEntity(propertyService.getPropertyById(id), HttpStatus.OK);
    }

    @PostMapping(path = "/saveProperty",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GetPropertyDto> saveProperty(@Valid @RequestBody CreatePropertyDto createPropertyDto) {
        return new ResponseEntity(propertyService.saveProperty(createPropertyDto), HttpStatus.CREATED);
    }

    @PutMapping(path = "/updateProperty",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GetPropertyDto> updateProperty(@Valid @RequestBody UpdatePropertyDto updatePropertyDto) throws PropertyException {
        return new ResponseEntity(propertyService.updateProperty(updatePropertyDto), HttpStatus.OK);
    }

    @DeleteMapping(path = "/deleteProperty/{id}")
    public ResponseEntity<String> deleteProperty(@PathVariable Long id) throws PropertyException {
        return new ResponseEntity(MessageDto.builder().message(propertyService.deleteProperty(id)).build(), HttpStatus.OK);
    }
}
