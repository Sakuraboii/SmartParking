package smartParking.back.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import smartParking.back.dto.CarsDTO;
import smartParking.back.models.User;
import smartParking.back.services.CarsService;
import smartParking.back.services.UserService;

import java.util.Map;


@RestController
@RequestMapping("/car")
public class CarsController {

    CarsService carsService;

    UserService userService;

    @Autowired
    public CarsController(CarsService carsService,
                          UserService userService) {
        this.userService = userService;
        this.carsService = carsService;
    }

    @GetMapping("/{id}")
    public CarsDTO getCarById(@PathVariable("id") Long id) {
        return new CarsDTO(carsService.getById(id));
    }

    @PostMapping("/addNewCar")
    public ResponseEntity addNewCar(@RequestBody Map<String, String> body) {
        User user = userService.getByName(body.get("userName"));
        carsService.create(body.get("vinNumber")
                , body.get("typeCarBody")
                , body.get("carNumbers")
                , user);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/deleteCar/{id}")
    public ResponseEntity deleteCar(@PathVariable("id") Long id){
        carsService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
