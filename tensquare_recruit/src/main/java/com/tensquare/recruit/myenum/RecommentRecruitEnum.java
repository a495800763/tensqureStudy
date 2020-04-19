package com.tensquare.recruit.myenum;

/**
 * @program: tensqureStudy
 * @author: liumq
 * @create: 2020-04-19 12:23
 **/
public enum RecommentRecruitEnum {

    //关闭
    IS_CLOSED_RECRUIT("0", 0),
    //开启
    IS_OPEN_RECRUIT("1", 1),
    //推荐
    IS_RECOMMENT_RECRUIT("2", 2);


    private String codeStr;
    private Integer code;

    private RecommentRecruitEnum(String codeStr, Integer code) {
        this.codeStr = codeStr;
        this.code = code;
    }

    public String getCodeStr() {
        return codeStr;
    }

    public Integer getCode() {
        return code;
    }
}
