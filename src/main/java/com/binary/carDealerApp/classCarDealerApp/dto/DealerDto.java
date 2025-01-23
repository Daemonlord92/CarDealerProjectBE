package com.binary.carDealerApp.classCarDealerApp.dto;

public class DealerDto {

    private String name;

    public DealerDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "DealerDto{" +
                "name='" + name + '\'' +
                '}';
    }
}
