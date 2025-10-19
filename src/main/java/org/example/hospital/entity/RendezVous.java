package org.example.hospital.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Date;
@Entity
@Data @NoArgsConstructor
@AllArgsConstructor
public class RendezVous {
    @jakarta.persistence.Id
    private Long id;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Date date;
    @Enumerated(EnumType.STRING)
    private StatusRDV status;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    private Patient patient ;
    @ManyToOne
    private Medecin medecin ;
    @OneToOne(mappedBy = "rendezVous")
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    private Consultation consultation ;
}
