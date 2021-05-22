package smartParking.back.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smartParking.back.models.Order;
import smartParking.back.models.VehicleType;
import smartParking.back.repositories.OrderRepository;
import smartParking.back.services.OrderService;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public void update(Order order) {
        save(order);
    }

    @Override
    public Order getById(Long id) {
        return orderRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Order> getAll() {
        List<Order> orders = new ArrayList<>();
        orderRepository.findAll().forEach(orders::add);
        return orders;
    }

    @Override
    public void delete(Order order) {
        orderRepository.delete(order);
    }

    @Override
    public void delete(Long id) {
        orderRepository.deleteById(id);
    }
}
