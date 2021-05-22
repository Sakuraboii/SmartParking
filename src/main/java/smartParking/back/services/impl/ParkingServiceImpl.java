package smartParking.back.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smartParking.back.models.Parking;
import smartParking.back.models.User;
import smartParking.back.repositories.CarsRepository;
import smartParking.back.repositories.ParkingRepository;
import smartParking.back.services.ParkingService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParkingServiceImpl implements ParkingService {

    ParkingRepository parkingRepository;

    @Autowired
    public ParkingServiceImpl(ParkingRepository parkingRepository) {
        this.parkingRepository = parkingRepository;
    }

    @Override
    public Parking save(Parking parking) {
        return parkingRepository.save(parking);
    }

    @Override
    public void update(Parking parking) {
        save(parking);
    }

    @Override
    public Parking getById(Long id) {
        return parkingRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Parking> getAll() {
        List<Parking> parkings = new ArrayList<>();
        parkingRepository.findAll().forEach(parkings::add);
        return parkings;
    }

    @Override
    public void delete(Parking parking) {
        parkingRepository.delete(parking);
    }

    @Override
    public void delete(Long id) {
        parkingRepository.deleteById(id);
    }
}
