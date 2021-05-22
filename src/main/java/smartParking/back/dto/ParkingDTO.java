package smartParking.back.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import smartParking.back.models.Order;
import smartParking.back.models.Parking;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ParkingDTO {

    private String address;

    private int numberOfParkingSpaces;

    private int price;

    private List<Order> orders;

    public ParkingDTO(Parking parking){
        this.address = parking.getAddress();
        this.numberOfParkingSpaces = parking.getNumberOfParkingSpaces();
        this.orders = parking.getOrders();
        this.price = parking.getPrice();
    }
}
