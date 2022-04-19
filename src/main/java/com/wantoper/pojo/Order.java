package com.wantoper.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
public class Order {
    private String id;
    private String uid;
    private LocalDateTime createdate;
    private float ordermoney;
}
