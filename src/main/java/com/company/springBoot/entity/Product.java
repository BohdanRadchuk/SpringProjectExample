package com.company.springBoot.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(schema = "springSchema", name = "springData")
public class Product {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "id", unique = true)
    private UUID id;

    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "price")
    BigDecimal price;

    @Column(name = "manufacturer")
    Manufacturer manufacturer;
}
