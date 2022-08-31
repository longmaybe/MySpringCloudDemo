package com.nifu.entity;

import lombok.Data;

@Data
public class Menu {
    private Integer id;
    private String name;
    private double price;
    private  String flavor;
    private  Integer tid;
}