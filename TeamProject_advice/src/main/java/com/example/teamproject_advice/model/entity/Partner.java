package com.example.teamproject_advice.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Partner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String status;
    private String address;
    private String call_center;
    private String partner_number;
    private String business_number;
    private String ceo_name;

    private LocalDateTime registered_at;
    private LocalDateTime unregistered_at;

    private LocalDateTime created_at;
    private String created_by;

    private LocalDateTime updated_at;
    private String updated_by;

    private Long category_id;

}
