package com.community.services.pojo.area;

/**
 * 区
 */
public class Area {

    private int id;
    private int city_id;
    private String code;
    private String name;
    private String city_code;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
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

    public String getCity_code() {
        return city_code;
    }

    public void setCity_code(String city_code) {
        this.city_code = city_code;
    }

    @Override
    public String toString() {
        return "Area{" +
                "id=" + id +
                ", city_id=" + city_id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", city_code='" + city_code + '\'' +
                '}';
    }
}
