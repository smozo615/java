package com.taxi.taxi.persistence.mappers;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.taxi.taxi.domain.models.Bill;
import com.taxi.taxi.persistence.entities.BillEntity;

@Mapper(componentModel = "spring")
public interface BillMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "totalAmount", target = "totalAmount"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "userId", target = "userId")
    })
    Bill toBill(BillEntity billEntity);

    List<Bill> toBills(List<BillEntity> billEntities);

    @InheritInverseConfiguration
    @Mapping(target = "user", ignore = true)
    BillEntity toBillEntity(Bill bill);
}
