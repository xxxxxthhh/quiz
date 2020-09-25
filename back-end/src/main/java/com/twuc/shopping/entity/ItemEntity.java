package com.twuc.shopping.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "item")
@Builder
public class ItemEntity {
  @Id
  @GeneratedValue
  private int id;
  private String itemName;
  private double price;
  private String measureUnit;
  private String imageUrl;
}

