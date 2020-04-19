package com.tensquare.recruit.myenum;

public enum HotListEnum {
    IS_HOT("1",1),
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
