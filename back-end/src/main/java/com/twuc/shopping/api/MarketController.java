package com.twuc.shopping.api;

import com.twuc.shopping.entity.ItemEntity;
import com.twuc.shopping.repository.ItemRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class MarketController {

  private final ItemRepository itemRepository;

  public MarketController(ItemRepository itemRepository) {
    this.itemRepository = itemRepository;
  }

  @PostMapping("/market/item")
  @CrossOrigin
  public ResponseEntity addItem(@RequestBody @Validated ItemEntity itemEntity){
    itemRepository.save(itemEntity);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @GetMapping("/market")
  public ResponseEntity findAllItem(){
    List<ItemEntity> itemEntities = itemRepository.findAll();
    return ResponseEntity.status(HttpStatus.CREATED).body(itemEntities);
  }
}
