package smartParking.back.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import smartParking.back.models.Order;
import smartParking.back.models.User;
import smartParking.back.models.VehicleType;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private String userName;

    private String password;

    private int driverLicenseNumber;

    private List<VehicleType> cars;

    private List<Order> orders;

    public UserDTO(User user) {
        this.cars = user.getCars();
        this.driverLicenseNumber = user.getDriverLicenseNumber();
        this.orders = user.getOrders();
        this.userName = user.getUserName();
        this.password = user.getPassword();
    }
}
