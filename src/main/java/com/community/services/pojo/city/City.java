package com.community.services.pojo.city;

/**
 * 市
 */
public class City {

    private int id;
    private int province_id;
    private String code;
    private String name;
    private String province_code;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProvince_id() {
        return province_id;
    }

    public void setProvince_id(int province_id) {
        this.province_id = province_id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvince_code() {
        return province_code;
    }

    public void setProvince_code(String province_code) {
        this.province_code = province_code;
    }

    @Override
    public String toString() {
        return "city{" +
                "id=" + id +
                ", province_id=" + province_id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", province_code='" + province_code + '\'' +
                '}';
    }
}
