package smartParking.back.services;

import smartParking.back.models.User;
import smartParking.back.models.VehicleType;

public interface CarsService extends CrudService<VehicleType>{
    VehicleType create(String vinNumber,
                       String typeCarBody,
                       String carNumbers,
                       User userMachine);
}
