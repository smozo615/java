package com.taxi.taxi.persistence.crud;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.taxi.taxi.persistence.entities.BillEntity;

public interface BillCrud extends CrudRepository<BillEntity, Long> {

    public List<BillEntity> findByUserId(Long id);
}
