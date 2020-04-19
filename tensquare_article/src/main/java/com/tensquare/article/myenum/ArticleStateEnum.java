package com.tensquare.article.myenum;

public enum ArticleStateEnum {
    // 文章审核通过
    ARTICLE_ADOPTED_STATE("1",1),
    // 文章审核未通过
    ARTICLE_NOT_ADOPTED_STATE("0",0);

    private String stateStr;
    private Integer state;

    ArticleStateEnum(String stateStr, Integer state) {
        this.stateStr = stateStr;
        this.state = state;
    }

    public String getStateStr() {
        return stateStr;
    }

    public Integer getState() {
        return state;
    }
}
