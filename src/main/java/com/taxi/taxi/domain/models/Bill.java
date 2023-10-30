package com.taxi.taxi.domain.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bill {
    private Long id;
    private double totalAmount;
    private String description;
    private Long userId;
}
