package com.community.services.controller.community;

import com.community.services.pojo.area.Area;
import com.community.services.pojo.city.City;
import com.community.services.pojo.provinces.Provinces;
import com.community.services.pojo.provinces.ProvincesExample;
import com.community.services.service.address.AddressService;
import com.community.services.utils.RedisTemplateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @Autowired
    private RedisTemplateUtils redisTemplateUtils;

    @RequestMapping("/all")
    public Map<String, List<Object>> findAddressAll(){
        Map<String,List<Object>> map = new HashMap<>();
        List<Area> areas = addressService.AreaList();
        List<City> cities = addressService.CityList();
        List<Provinces> provinces = addressService.provincesList();
        map.put("areas", Collections.singletonList(areas));
        map.put("cities", Collections.singletonList(cities));
        map.put("provinces", Collections.singletonList(provinces));
        return map;
    }

    @RequestMapping("/addressList")
    public List<ProvincesExample> AddressList() {
        List<ProvincesExample> provincesExampleList = new ArrayList<>();
        if (redisTemplateUtils.get("addressList") == null){
            provincesExampleList = addressService.AddressList();
            redisTemplateUtils.set("addressList",provincesExampleList);
        }else {
            provincesExampleList = (List<ProvincesExample>) redisTemplateUtils.get("addressList");
        }
        return provincesExampleList;
    }

}
