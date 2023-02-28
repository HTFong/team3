package com.example.utils;

public enum OrderStatus {
    CHO_XAC_NHAN("Chờ xác nhận"),
    DANG_GIAO("Đang giao");
//    DA_GIAO("Đã giao"),
//    DA_HUY("Đã hủy");
    private String value;

    public String getValue() {
        return value;
    }

    OrderStatus(String value) {
        this.value = value;
    }
}
