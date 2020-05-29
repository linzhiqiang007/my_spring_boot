package com.community.services.service.impl.address;

import com.community.services.mapper.area.AreaMapper;
import com.community.services.mapper.city.CityMapper;
import com.community.services.mapper.provinces.ProvincesMapper;
import com.community.services.pojo.area.Area;
import com.community.services.pojo.city.City;
import com.community.services.pojo.city.CityExample;
import com.community.services.pojo.provinces.Provinces;
import com.community.services.pojo.provinces.ProvincesExample;
import com.community.services.service.address.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Reference;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {

    @Autowired
    private ProvincesMapper provincesMapper;

    @Autowired
    private CityMapper cityMapper;

    @Autowired
    @Reference
    private AreaMapper areaMapper;

    /**
     * 查询所有省级级数据
     * @return
     */
    @Override
    public List<Provinces> provincesList() {
        return provincesMapper.provincesList();
    }

    /**
     * 查询所有市级数据
     * @return
     */
    @Override
    public List<Area> AreaList() {
        return areaMapper.AreaList();
    }

    /**
     * 查询所有区级数据
     * @return
     */
    @Override
    public List<City> CityList() {
        return cityMapper.CityList();
    }

    /**
     * 查询省市区三级联调
     * @return
     */
    @Override
    public List<ProvincesExample> AddressList() {
        List<Provinces> provinces = provincesMapper.provincesList();
        List<ProvincesExample> provincesExampleList = new ArrayList<>();
        for (Provinces province : provinces) {
            List<City> cities = cityMapper.CityListByProvinceCode(province.getProvinceid());
            List<CityExample> cityExamples = new ArrayList<>();
            ProvincesExample provincesExample = new ProvincesExample();
            for (City city : cities) {
                List<Area> areas = areaMapper.AreaListByCityCode(city.getCode());
                CityExample cityExample = new CityExample();
                cityExample.setId(city.getId());
                cityExample.setCode(city.getCode());
                cityExample.setName(city.getName());
                cityExample.setProvince_code(city.getProvince_code());
                cityExample.setProvince_id(city.getProvince_id());
                cityExample.setAreaList(areas);
                cityExamples.add(cityExample);
            }
            provincesExample.setId(province.getId());
            provincesExample.setProvince(province.getProvince());
            provincesExample.setProvinceid(province.getProvinceid());
            provincesExample.setCityList(cityExamples);
            provincesExampleList.add(provincesExample);
        }
        return provincesExampleList;
    }

}
