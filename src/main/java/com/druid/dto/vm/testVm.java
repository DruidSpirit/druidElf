package com.druid.dto.vm;

public class testVm {
    private Integer id;
    private Integer type;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public testVm() {
    }

    public testVm(Integer id, Integer type, String name) {
        this.id = id;
        this.type = type;
        this.name = name;
    }
}
