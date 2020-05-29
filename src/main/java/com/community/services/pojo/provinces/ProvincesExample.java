package com.community.services.pojo.provinces;

import com.community.services.pojo.city.City;
import com.community.services.pojo.city.CityExample;

import java.util.List;

public class ProvincesExample {

    private int id;
    private String provinceid;
    private String province;

    private List<CityExample> cityList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProvinceid() {
        return provinceid;
    }

    public void setProvinceid(String provinceid) {
        this.provinceid = provinceid;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public List<CityExample> getCityList() {
        return cityList;
    }

    public void setCityList(List<CityExample> cityList) {
        this.cityList = cityList;
    }
}
