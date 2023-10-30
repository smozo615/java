package com.taxi.taxi.persistence.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.taxi.taxi.domain.interfaces.IBillRepository;
import com.taxi.taxi.domain.models.Bill;
import com.taxi.taxi.persistence.crud.BillCrud;
import com.taxi.taxi.persistence.entities.BillEntity;
import com.taxi.taxi.persistence.mappers.BillMapper;

@Repository
public class BillRepository implements IBillRepository {
    private final BillCrud billCrud;

    @Autowired
    private BillMapper mapper;

    public BillRepository(BillCrud billCrud) {
        this.billCrud = billCrud;
    }

    @Override
    public Bill save(Bill bill) {
        BillEntity billEntity = billCrud.save(mapper.toBillEntity(bill));

        return mapper.toBill(billEntity);
    }

    @Override
    public Optional<Bill> findById(Long id) {
        return billCrud.findById(id).map(entity -> mapper.toBill(entity));
    }

    @Override
    public Optional<List<Bill>> findByUserId(Long userId) {
        List<BillEntity> billEntities = billCrud.findByUserId(userId);

        return Optional.of(mapper.toBills(billEntities));
    }

    @Override
    public List<Bill> findAll() {
        List<BillEntity> billEntities = (List<BillEntity>) billCrud.findAll();

        return mapper.toBills(billEntities);
    }

    @Override
    public void delete(long id) {
        billCrud.deleteById(id);
    }
}
