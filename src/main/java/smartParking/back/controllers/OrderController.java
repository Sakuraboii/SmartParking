package smartParking.back.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import smartParking.back.models.Order;
import smartParking.back.services.OrderService;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/allOrders")
    public List<Order> getAllOrders() {
        return orderService.getAll();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable("id") Long id) {
        return orderService.getById(id);
    }
}
