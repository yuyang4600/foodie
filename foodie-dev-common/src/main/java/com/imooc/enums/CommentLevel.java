package com.imooc.enums;

public enum CommentLevel {
    GOOD(1, "好评"),
    NORMAL(2, "中评"),
    BAD(3, "差评"),
    ;

    public Integer type;
    public String desc;

    CommentLevel(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }
}
