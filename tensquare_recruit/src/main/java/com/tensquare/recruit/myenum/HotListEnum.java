package com.tensquare.recruit.myenum;

public enum HotListEnum {
    //热门企业
    IS_HOT("1",1),
    //非热门企业
    IS_NOT_HOT("0",0);

    private String status;
    private Integer statusInt;

    HotListEnum(String status, Integer statusInt) {
        this.status = status;
        this.statusInt = statusInt;
    }

    public String getStatus() {
        return status;
    }

    public Integer getStatusInt() {
        return statusInt;
    }
}
