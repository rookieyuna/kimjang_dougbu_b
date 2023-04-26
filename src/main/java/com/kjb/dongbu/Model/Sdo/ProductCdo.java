package com.kjb.dongbu.Model.Sdo;

import com.kjb.dongbu.Model.Vo.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductCdo {

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
}
