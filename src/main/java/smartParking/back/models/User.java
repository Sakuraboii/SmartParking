package smartParking.back.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "user")
public class User extends BaseEntity {

    @NotNull
    @Column(name = "userName")
    private String userName;

    @NotNull
    @Column(name = "password")
    private String password;

    @Transient
    private String confirmPassword;

    @NotNull
    @Column(name = "driverLicenseNumber")
    private int driverLicenseNumber;

    @OneToMany(mappedBy = "userMachine", fetch = FetchType.LAZY)
    private List<VehicleType> cars;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Order> orders;

}
