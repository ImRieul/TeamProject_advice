package com.example.teamproject_advice.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;
    private String name;
    private String title;
    private //TEXT content;
    private //Decimal price;
    private String brand_name;

    private LocalDateTime registered_at;
    private LocalDateTime unregistered_at;

    private LocalDateTime created_at;
    private String created_by;

    private LocalDateTime updated_at;
    private String updated_by;

    private Long partner_id;

}
