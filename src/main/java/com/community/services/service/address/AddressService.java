package com.community.services.service.address;

import com.community.services.pojo.area.Area;
import com.community.services.pojo.city.City;
import com.community.services.pojo.provinces.Provinces;
import com.community.services.pojo.provinces.ProvincesExample;

import java.util.List;

public interface AddressService {

    List<Provinces> provincesList();

    List<Area> AreaList();

    List<City> CityList();

    List<ProvincesExample> AddressList();

}
