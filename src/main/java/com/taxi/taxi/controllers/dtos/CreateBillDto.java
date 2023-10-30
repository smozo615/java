package com.taxi.taxi.controllers.dtos;

import com.taxi.taxi.domain.models.Bill;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateBillDto {
    @NotNull(message = "userId required")
    private Long userId;

    @NotNull(message = "totalAmount")
    private Double totalAmount;

    @NotEmpty(message = "description required")
    private String description;

    public Bill toBill() {
        Bill bill = new Bill();
        bill.setDescription(this.description);
        bill.setTotalAmount(this.totalAmount);
        bill.setUserId(this.userId);
        return bill;
    }
}
