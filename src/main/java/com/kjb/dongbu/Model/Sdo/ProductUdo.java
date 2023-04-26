package com.kjb.dongbu.Model.Sdo;

import com.kjb.dongbu.Model.Vo.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductUdo {

    private String pdCode;
    private ProductType productType;
    private String productEtc;
    private RepairType repairType;
    private TextureType textureType;
    private SizeType sizeType;
    private String color;
    private YesOrNo premiumYn;
    private int price;
}
