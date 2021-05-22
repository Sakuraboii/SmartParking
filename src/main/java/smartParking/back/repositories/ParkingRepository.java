package smartParking.back.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import smartParking.back.models.Parking;

import java.util.Optional;

@Repository
public interface ParkingRepository extends CrudRepository<Parking, Long> {
    Optional<Parking> findByAddress(String address);
}
