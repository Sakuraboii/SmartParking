package smartParking.back.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import smartParking.back.models.Order;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {

    private String cost;

    private Date checkInTime;

    private Date departureTime;

    private String parkingTime;

    private ParkingDTO park;

    public OrderDTO(Order order) {
        this.checkInTime = order.getCheckInTime();
        this.cost = order.getCost();
        this.departureTime = order.getDepartureTime();
        this.parkingTime = order.getParkingTime();
        if (order.getPark() != null) {
            this.park = new ParkingDTO(order.getPark());
        }
    }
}
