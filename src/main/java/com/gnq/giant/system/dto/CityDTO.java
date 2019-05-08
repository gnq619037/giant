package com.gnq.giant.system.dto;

import java.util.List;

/**
 * @author: guonanqing
 * @desc:
 * @date:
 */
public class CityDTO {
    private Long id;
    private Long fatherId;
    private String cityName;
    private Integer level;
    private List<CityDTO> cityDTO;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFatherId() {
        return fatherId;
    }

    public void setFatherId(Long fatherId) {
        this.fatherId = fatherId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public List<CityDTO> getCityDTO() {
        return cityDTO;
    }

    public void setCityDTO(List<CityDTO> cityDTO) {
        this.cityDTO = cityDTO;
    }
}
