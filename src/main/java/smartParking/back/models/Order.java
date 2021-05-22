package smartParking.back.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "order")
public class Order extends BaseEntity {

    @NotNull
    @Column(name = "cost")
    private String cost;

    @NotNull
    @Column(name = "checkInTime")
    private Date checkInTime;

    @NotNull
    @Column(name = "departureTime")
    private Date departureTime;

    @NotNull
    @Column(name = "parkingTime")
    private String parkingTime;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable=false)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "park_id")
    private Parking park;
}
