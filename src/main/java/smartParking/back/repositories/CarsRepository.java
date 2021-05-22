package smartParking.back.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import smartParking.back.models.VehicleType;

@Repository
public interface CarsRepository extends CrudRepository<VehicleType, Long> {
}
