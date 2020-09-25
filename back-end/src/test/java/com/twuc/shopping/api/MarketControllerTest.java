package com.twuc.shopping.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twuc.shopping.entity.ItemEntity;
import com.twuc.shopping.repository.ItemRepository;
import org.junit.jupiter.api.BeforeEach;
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
class MarketControllerTest {

  @Autowired
  MockMvc mockMvc;
  @Autowired
  ItemRepository itemRepository;

  @BeforeEach
  void setUp() {
    itemRepository.deleteAll();
  }

  @Test
  void addItem() throws Exception {
    ItemEntity itemEntity = ItemEntity.builder()
        .itemName("milk")
        .price(5)
        .measureUnit("bottle")
        .imageUrl("imageUrl")
        .build();

    ObjectMapper objectMapper = new ObjectMapper();
    String jsonValue = objectMapper.writeValueAsString(itemEntity);

    mockMvc.perform(post("/market/item").contentType(MediaType.APPLICATION_JSON).content(jsonValue))
        .andExpect(status().isCreated());

    mockMvc.perform(get("/market")).andExpect(jsonPath("$", hasSize(1)));
  }
}