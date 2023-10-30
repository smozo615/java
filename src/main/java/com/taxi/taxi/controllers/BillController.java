package com.taxi.taxi.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taxi.taxi.controllers.dtos.CreateBillDto;
import com.taxi.taxi.domain.models.Bill;
import com.taxi.taxi.domain.services.BillService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/bills")
public class BillController {
    private final BillService billService;

    public BillController(BillService billService) {
        this.billService = billService;
    }

    @PostMapping("")
    public ResponseEntity<Bill> save(@Valid @RequestBody CreateBillDto billDto) {
        return new ResponseEntity<Bill>(billService.save(billDto.toBill()), HttpStatus.CREATED);
    }

    @PatchMapping("{id}")
    public ResponseEntity<Bill> update(@PathVariable("id") Long id, @Valid @RequestBody CreateBillDto billDto) {
        Bill bill = billDto.toBill();

        bill.setId(id);

        return new ResponseEntity<>(billService.save(bill), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        if (billService.delete(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
