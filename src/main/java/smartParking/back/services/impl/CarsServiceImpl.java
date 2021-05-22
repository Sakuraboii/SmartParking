package smartParking.back.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smartParking.back.models.User;
import smartParking.back.models.VehicleType;
import smartParking.back.repositories.CarsRepository;
import smartParking.back.services.CarsService;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarsServiceImpl implements CarsService {

    CarsRepository carsRepository;

    @Autowired
    public CarsServiceImpl(CarsRepository carsRepository) {
        this.carsRepository = carsRepository;
    }

    @Override
    public VehicleType save(VehicleType vehicleType) {
        return carsRepository.save(vehicleType);
    }

    @Override
    public void update(VehicleType vehicleType) {
        save(vehicleType);
    }

    @Override
    public VehicleType getById(Long id) {
        return carsRepository.findById(id).orElseThrow();
    }

    @Override
    public List<VehicleType> getAll() {
        List<VehicleType> cars = new ArrayList<>();
        carsRepository.findAll().forEach(cars::add);
        return cars;
    }

    @Override
    public void delete(VehicleType vehicleType) {
        carsRepository.delete(vehicleType);
    }

    @Override
    public void delete(Long id) {
        carsRepository.deleteById(id);
    }

    @Override
    public VehicleType create(String vinNumber,
                              String typeCarBody,
                              String carNumbers,
                              User userMachine) {
        VehicleType vehicleType = new VehicleType(vinNumber,typeCarBody,carNumbers,userMachine);
        return carsRepository.save(vehicleType);
    }
}
