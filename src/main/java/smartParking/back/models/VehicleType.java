package smartParking.back.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "VehicleType")
public class VehicleType extends BaseEntity {

    @NotNull
    @Column(name = "vinNumber")
    private String vinNumber;

    @NotNull
    @Column(name = "typeCarBody")
    private String typeCarBody;

    @NotNull
    @Column(name = "carNumbers")
    private String carNumbers;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "user_id")
    private User userMachine;
}
