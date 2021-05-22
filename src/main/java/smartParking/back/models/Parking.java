package smartParking.back.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "parking")
public class Parking extends BaseEntity {

    @NotNull
    @Column(name = "address")
    private String address;

    @NotNull
    @Column(name = "spaces")
    private int numberOfParkingSpaces;

    @NotNull
    @Column(name = "price")
    private int price;

    @OneToMany(mappedBy = "parking", fetch = FetchType.LAZY)
    private List<Order> orders;
}
