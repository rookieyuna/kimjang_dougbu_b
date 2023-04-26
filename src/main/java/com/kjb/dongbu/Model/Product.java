package com.kjb.dongbu.Model;

import com.kjb.dongbu.Model.Sdo.ProductCdo;
import com.kjb.dongbu.Model.Vo.*;
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
    private String pdCode;
    private String htCode;
    private int label;
    private OrderType orderType;
    private ProductType productType;
    private String productEtc;
    private RepairType repairType;
    private TextureType textureType;
    private SizeType sizeType;
    private String color;
    private YesOrNo premiumYn;
    private int price;

    public Product(ProductCdo productCdo){
        BeanUtils.copyProperties(productCdo, this);
    }
}
