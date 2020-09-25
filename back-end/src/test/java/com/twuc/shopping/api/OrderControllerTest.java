package com.twuc.shopping.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twuc.shopping.entity.OrderEntity;
import com.twuc.shopping.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class OrderControllerTest {
  @Autowired
  MockMvc mockMvc;

  @Autowired
  OrderRepository orderRepository;

  @Test
  void getOrders() throws Exception {
    mockMvc.perform(get("/orders"))
        .andExpect(jsonPath("$", hasSize(0)))
        .andExpect(status().isOk());
  }

  @Test
  void deleteOrder() {

  }

  @Test
  void deleteOrderById() {
  }

  @Test
  void addOrder() throws Exception {
    OrderEntity orderEntity = OrderEntity.builder().orderName("hi").numCount(1).itemId(1).build();
    ObjectMapper objectMapper = new ObjectMapper();
    String orderStr = objectMapper.writeValueAsString(orderEntity);
    mockMvc.perform(post("/addOrder").contentType(MediaType.APPLICATION_JSON).content(orderStr)).andExpect(status().isCreated());
  }
}