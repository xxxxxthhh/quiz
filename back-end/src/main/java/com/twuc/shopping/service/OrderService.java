package com.twuc.shopping.service;

import com.twuc.shopping.dto.OrderDto;
import com.twuc.shopping.entity.OrderEntity;
import com.twuc.shopping.repository.OrderRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

  private final OrderRepository orderRepository;

  public OrderService(OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }

  public List<OrderDto> getOrderList() {
    List<OrderEntity> orderEntities = orderRepository.findAll();
    List<OrderDto> orderDtos = new ArrayList<>();
    orderEntities.stream().forEach(
        orderEntity -> {
          OrderDto orderDto = OrderDto.builder().orderName(orderEntity.getOrderName()).itemId(orderEntity.getItemId()).numCount(1).build();
          orderDtos.add(orderDto);
        }
    );
    return orderDtos;
  }

  @Transactional
  public void deleteOrder() {
    orderRepository.deleteAll();
  }

  @Transactional
  public void deleteOrderById(int id) {
    orderRepository.deleteById(id);
  }

  @Transactional
  public void addOrder(OrderEntity orderEntity) {
    orderRepository.save(orderEntity);
  }
  @Transactional
  public List<OrderEntity> getOrders() {
    return orderRepository.findAll();
  }
}
