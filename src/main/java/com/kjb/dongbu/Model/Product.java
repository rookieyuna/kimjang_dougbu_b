package com.kjb.dongbu.Model;

import com.kjb.dongbu.Model.Sdo.ProductCdo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
public class Product {

    @Id
    private String p_code;
    private Integer c_code;
    private Integer label;
    private String h_code;
    private Integer order;
    private String color;
    private String premium_yn;
    private Integer price;

    public Product(ProductCdo productCdo){
        BeanUtils.copyProperties(productCdo, this);
    }
}
