package ucentral.edu.co.mikaza.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@Builder
@Data
@Entity
@NoArgsConstructor
@Table(name = "property")
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;

    private String zone;

    private Integer price;

    @Column(name = "entry_date")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date entryDate;

    @Column(name = "exit_date")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date exitDate;

    @Column(name = "number_people")
    private Short numberPeople;

    @Column(name = "accommodation_type")
    private String accommodationType;

    @Column(name = "additional_services")
    private String additionalServices;

    private String image;
}
