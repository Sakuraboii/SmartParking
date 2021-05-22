package smartParking.back.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import smartParking.back.dto.CarsDTO;
import smartParking.back.dto.OrderDTO;
import smartParking.back.dto.UserDTO;
import smartParking.back.services.UserService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public List<UserDTO> getAllUsers() {
        List<UserDTO> userDTOList = new ArrayList<>();
        userService.getAll().forEach(tutorial ->
        {
            userDTOList.add(new UserDTO(tutorial));
        });
        return userDTOList;
    }

    @GetMapping("/{id}")
    public UserDTO getUser(@PathVariable("id") Long id) {
        return new UserDTO(userService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable("id") Long id) {
        userService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}/cars")
    public List<CarsDTO> getUserCars(@PathVariable("id") Long id){
        List<CarsDTO> carsDTOS = new ArrayList<>();
        userService.getById(id).getCars().forEach(cars -> carsDTOS.add(new CarsDTO(cars)));
        return carsDTOS;
    }

    @GetMapping("/{id}/orders")
    public List<OrderDTO> getUserOrders(@PathVariable("id")Long id){
        List<OrderDTO> orderDTOS = new ArrayList<>();
        userService.getById(id).getOrders().forEach(orders -> orderDTOS.add(new OrderDTO(orders)));
        return orderDTOS;
    }
}
