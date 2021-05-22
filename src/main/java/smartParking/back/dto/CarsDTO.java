package smartParking.back.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import smartParking.back.models.VehicleType;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarsDTO {

    private String carNumbers;

    private UserDTO userMachine;

    public CarsDTO(VehicleType car){
        this.carNumbers = car.getCarNumbers();
        if (car.getUserMachine() != null) {
            this.userMachine = new UserDTO(car.getUserMachine());
        }
    }
}
