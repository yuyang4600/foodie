package com.imooc.enums;

public enum CarouseIsShow {
    Yes(1, "是"),
    NO(0, "否"),
    ;

    public final Integer type;
    public final String value;

    CarouseIsShow(Integer type, String value) {
        this.type = type;
        this.value = value;
    }
}
