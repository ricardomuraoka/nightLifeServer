package br.pucpr.nightlifeserver.rest.establishments;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(
        name = "Establishments.getAllEstablishments",
        query = "SELECT e FROM Establishments e" +
                " ORDER BY e.name"
)
public class Establishments {
    @Id
    @GeneratedValue
    private UUID id;
    @NotBlank
    private String name;
    private String style;
    private Boolean verified;
    private String email;
    private String phone;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String website;
    private Boolean open_monday;
    private Boolean open_tuesday;
    private Boolean open_wednesday;
    private Boolean open_thursday;
    private Boolean open_friday;
    private Boolean open_saturday;
    private Boolean open_sunday;
    private String open;
    private String close;
    private Boolean approved;
    private Date created_at;
    private Date updated_at;
    private Boolean deleted;
    private Date deleted_at;
    private String comment;
}
