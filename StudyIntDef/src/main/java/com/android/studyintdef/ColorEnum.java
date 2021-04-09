package com.android.studyintdef;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zach
 */
public enum ColorEnum {

    RED("red", "红色"),
    GREEN("green", "绿色"),
    WHITE("white", "白色"),
    YELLOW("yellow", "黄色");

    // 成员变量
    private String name;
    private String value;

    // 构造方法
    private ColorEnum(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    // 将数据缓存到map中
    private static final Map<String, String> map = new HashMap<String, String>();

    static {
        for (ColorEnum color : ColorEnum.values()) {
            map.put(color.getName(), color.getValue());
        }
    }

    // 根据name查询value值
    public static String getValueByName(String name) {
        return map.get(name);
    }

}