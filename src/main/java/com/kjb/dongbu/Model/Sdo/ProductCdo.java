package com.kjb.dongbu.Model.Sdo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductCdo {

    private Integer c_code;
    private Integer label;
    private String h_code;
    private Integer order;
    private String color;
    private String premium_yn;
    private Integer price;
}
