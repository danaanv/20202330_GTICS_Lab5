package com.example._20202330_gtics_lab5.entitys;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "regions")
public class Regions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "region_id",nullable = false)
    private BigDecimal region_id;

    @Column(name = "region_name",nullable = false)
    private String nombre;

}
