package com.kjb.dongbu.Repository.Jpo;

import com.kjb.dongbu.Model.History;
import com.kjb.dongbu.Model.Member;
import com.kjb.dongbu.Model.Product;
import com.kjb.dongbu.Model.Vo.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@Entity(name="product")
public class ProductJpo {

    @Id
    @Column(length = 20)
    private String pdCode;
    @Column(length = 20)
    private String htCode;
    @Column(nullable = false)
    private int label;
    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private OrderType orderType;
    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private ProductType productType;
    @Column(length = 200)
    private String productEtc;
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private RepairType repairType;
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private TextureType textureType;
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private SizeType sizeType;
    @Column(length = 20)
    private String color;
    @Column (length = 10, nullable = false)
    private YesOrNo premiumYn;
    @Column(nullable = false)
    private int price;


    public ProductJpo(Product product) {
        BeanUtils.copyProperties(product, this);
    }

    public Product toDomain() {
        Product product = new Product();
        BeanUtils.copyProperties(this, product);
        return product;
    }

    public static List<Product> toDomains(List<ProductJpo> productJpos) {
        return productJpos.stream().map(ProductJpo::toDomain).collect(Collectors.toList());
    }
}