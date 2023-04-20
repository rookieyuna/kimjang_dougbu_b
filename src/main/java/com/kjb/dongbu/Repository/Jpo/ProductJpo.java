package com.kjb.dongbu.Repository.Jpo;

import com.kjb.dongbu.Model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
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
    private String p_code;
    @Column(nullable = false)
    private Integer c_code;
    @Column(nullable = false)
    private Integer label;
    @Column(length = 20, nullable = false)
    private String h_code;
    @Column(length = 20, nullable = false)
    private Integer order;
    @Column(length = 20)
    private String color;
    @Column (length = 2)
    @ColumnDefault("'N'")
    private String premium_yn;
    @Column(nullable = false)
    private Integer price;

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