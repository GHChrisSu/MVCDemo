package com.baize.markettest.model;


import com.baize.markettest.constant.Constant;

/**
 * Created by lxb on 2017/2/8.
 */

public class AppDataEntity extends BaseData {

    private String name;

    private String address;

    private String status;

    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getItemType() {

        return Constant.APP_TYPE;
    }


}
