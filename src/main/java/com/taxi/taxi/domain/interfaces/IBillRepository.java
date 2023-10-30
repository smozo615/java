package com.taxi.taxi.domain.interfaces;

import java.util.List;
import java.util.Optional;

import com.taxi.taxi.domain.models.Bill;

public interface IBillRepository {
    Bill save(Bill bill);

    Optional<Bill> findById(Long id);

    Optional<List<Bill>> findByUserId(Long userId);

    List<Bill> findAll();
}
