package com.twuc.shopping.api;

import com.twuc.shopping.entity.OrderEntity;
import com.twuc.shopping.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

  private final OrderService orderService;

  public OrderController(OrderService orderService) {
    this.orderService = orderService;
  }

  @GetMapping("/orders")
  @CrossOrigin
  public ResponseEntity getOrders() {
    List<OrderEntity> orderEntities = orderService.getOrders();
    return ResponseEntity.status(HttpStatus.OK).body(orderEntities);
  }

  @PostMapping("/orderDelete")
  public ResponseEntity deleteOrder() {
    orderService.deleteOrder();
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @PostMapping("/orderDelete/{id}")
  public ResponseEntity deleteOrderById(@PathVariable int id) {
    orderService.deleteOrderById(id);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @PostMapping("/addOrder")
  public ResponseEntity addOrder(@RequestBody OrderEntity orderEntity) {
    orderService.addOrder(orderEntity);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }
}
