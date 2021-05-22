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
@Table(name = "cars")
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

    @ManyToOne
    @JoinColumn(name = "user_id", nullable=false)
    private User userMachine;
}
