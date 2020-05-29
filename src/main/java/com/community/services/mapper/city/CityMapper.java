package com.community.services.mapper.city;

import com.community.services.pojo.city.City;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CityMapper {

    List<City> CityList();

    List<City> CityListByProvinceCode(String province_code);

}
