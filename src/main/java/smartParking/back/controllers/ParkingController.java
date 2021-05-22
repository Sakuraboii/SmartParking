package smartParking.back.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import smartParking.back.models.Parking;
import smartParking.back.services.ParkingService;

import java.util.List;

@RestController
@RequestMapping("/parking")
public class ParkingController {

    ParkingService parkingService;

    @Autowired
    public ParkingController(ParkingService parkingService) {
        this.parkingService = parkingService;
    }

    @GetMapping("/allPark")
    public List<Parking> getAllPark() {
        return parkingService.getAll();
    }

    @GetMapping("/park/{id}")
    public Parking getPark(@PathVariable("id") Long id) {
        return parkingService.getById(id);
    }

    @DeleteMapping("/deletePark/{id}")
    public ResponseEntity deletePark(@PathVariable("id") Long id) {
        parkingService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/addPark")
    public ResponseEntity addPark() {
        // TODO: create add
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
