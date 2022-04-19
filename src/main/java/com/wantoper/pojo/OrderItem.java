package com.wantoper.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderItem {
    private String id;
    private int pid;
    private String oid;
    private int num;
    private Product p;
}

