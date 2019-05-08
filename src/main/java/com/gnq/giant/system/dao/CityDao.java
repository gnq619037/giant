package com.gnq.giant.system.dao;

import com.gnq.giant.system.dto.CityDTO;
import com.gnq.giant.system.entities.City;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CityDao {
    public List<CityDTO> findAll(CityDTO cityDTO);
}
