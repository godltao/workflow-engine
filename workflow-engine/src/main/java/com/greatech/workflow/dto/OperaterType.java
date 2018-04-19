package com.greatech.workflow.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bigbeard on 2017/6/27.
 * 配置判断业务对象支持的操作符
 */
public enum OperaterType {
    GREATER_THEN("大于", 1), LESS_THEN("小于", 2), GREATER_EQUEL("大于等于", 3), LESS_EQUEL("小于等于", 4), EQUEL("等于", 5), CONTAIN("包含", 6), IN("在..里面", 7), EXPRESSION("表达式", 8);
    private String name;
    private int index;

    private OperaterType(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public static String getName(int index) {
        for (OperaterType c : OperaterType.values()) {
            if (c.getIndex() == index) {
                return c.name;
            }
        }
        return null;
    }

    public static OperaterType valueOfIndex(int index) {
        for (OperaterType operaterType : OperaterType.values()) {
            if (operaterType.getIndex() == index) return operaterType;
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * 获取当前所有枚举对象
     *
     * @return
     */
    public List<OperaterType> getAll() {
        ArrayList<OperaterType> operaterTypes = new ArrayList<>();
        for (OperaterType o : OperaterType.values()) {
            operaterTypes.add(o);
        }
        return operaterTypes;
    }

}
