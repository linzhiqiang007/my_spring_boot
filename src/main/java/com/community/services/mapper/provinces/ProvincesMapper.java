package com.community.services.mapper.provinces;

import com.community.services.pojo.provinces.Provinces;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProvincesMapper {

    List<Provinces> provincesList();

}
