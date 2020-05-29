package com.community.services.mapper.area;

import com.community.services.pojo.area.Area;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AreaMapper {

    List<Area> AreaList();

    List<Area> AreaListByCityCode(String city_code);

}
