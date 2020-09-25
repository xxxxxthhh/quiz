package com.twuc.shopping.repository;

import com.twuc.shopping.entity.ItemEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemRepository extends CrudRepository<ItemEntity, Integer> {
  @Override
  List<ItemEntity> findAll();
}
