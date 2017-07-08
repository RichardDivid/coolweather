package com.booyue.demo.db;

import org.litepal.crud.DataSupport;

/**
 * Created by 15272 on 2017/7/8.
 *
 * 县级类
 */
public class Country extends DataSupport {

    private int id;
    private String countryName;//记录县的名字

    private String weatherId;//县对应的天气id

    private int cityId;//记录当前县所属的城市id

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getWeatherId() {
        return weatherId;
    }

    public void setWeatherId(String weatherId) {
        this.weatherId = weatherId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }
}
