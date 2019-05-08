package com.gnq.giant.system.controller;

import com.gnq.giant.system.service.CityService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author: guonanqing
 * @desc:
 * @date:
 */
@RestController
@RequestMapping(value = "/giant")
public class CityController {
    @Autowired
    private CityService cityService;

    @RequestMapping(value = "/city/all", method = RequestMethod.GET)
    public Object findAllCity(){
        Map<String, Object> map = cityService.findAllCity();
        return map;
    }
}
