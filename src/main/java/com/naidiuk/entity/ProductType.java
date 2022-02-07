package com.naidiuk.entity;

public enum ProductType {
    ALCOHOL("Alcohol"),
    FISH("Fish"),
    MEAT("Meat");

    private String title;

    ProductType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
