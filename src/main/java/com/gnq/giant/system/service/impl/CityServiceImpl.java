package com.gnq.giant.system.service.impl;

import com.gnq.giant.system.dao.CityDao;
import com.gnq.giant.system.dto.CityDTO;
import com.gnq.giant.system.entities.City;
import com.gnq.giant.system.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: guonanqing
 * @desc:
 * @date:
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao cityDao;

    public Map<String, Object> findAllCity() {
        Map<String, Object> map = new HashMap<String, Object>();
//        List<CityDTO> cityDTOList = cityDao.findAll(null);

        CityDTO cityDTO = new CityDTO();
        cityDTO.setLevel(0);
        List<CityDTO> oneLevelCity = cityDao.findAll(cityDTO);

        cityDTO.setLevel(1);
        List<CityDTO> twoLevelCity = cityDao.findAll(cityDTO);

        cityDTO.setLevel(2);
        List<CityDTO> threeLevelCity = cityDao.findAll(cityDTO);

        for(CityDTO oneCity : oneLevelCity){
            List<CityDTO> twoCities = new ArrayList<CityDTO>();
            for(CityDTO twoCity : twoLevelCity){
                if(twoCity.getFatherId().equals(oneCity.getId())){
                    List<CityDTO> threeCities = new ArrayList<CityDTO>();
                    for(CityDTO threeCity : threeLevelCity){
                        if(threeCity.getFatherId().equals(twoCity.getId())){
                            threeCities.add(threeCity);
                        }
                    }
                    twoCity.setCityDTO(threeCities);
                    twoCities.add(twoCity);
                }
            }
            oneCity.setCityDTO(twoCities);
        }
        map.put("success", true);
        map.put("result", oneLevelCity);
        return map;
    }
}
