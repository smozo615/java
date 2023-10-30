package com.taxi.taxi.domain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.taxi.taxi.domain.models.Bill;
import com.taxi.taxi.persistence.repositories.BillRepository;

@Service
public class BillService {
    private final BillRepository billRepository;

    public BillService(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    public Bill save(Bill bill) {
        return billRepository.save(bill);
    }

    public Optional<Bill> findById(Long id) {
        return billRepository.findById(id);
    }

    public Optional<List<Bill>> findByUserId(Long userId) {
        return billRepository.findByUserId(userId);
    }

    public List<Bill> findAll() {
        return billRepository.findAll();
    }

    public boolean delete(long id) {
        return findById(id).map(bill -> {
            billRepository.delete(id);
            return true;
        }).orElse(false);
    }
}
