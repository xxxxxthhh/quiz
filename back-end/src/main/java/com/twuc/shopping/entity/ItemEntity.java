package com.twuc.shopping.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

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
  @NotNull(message = "产品名称不能为空")
  private String name;
  @NotNull(message = "产品价格不能为空")
  @DecimalMin("0")
  private double price;
  @NotNull(message = "产品单位不能为空")
  private String measurement;
  @NotNull(message = "产品图片不能为空")
  private String image;
}

