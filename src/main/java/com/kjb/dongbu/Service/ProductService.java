package com.kjb.dongbu.Service;

import com.kjb.dongbu.Model.Product;
import com.kjb.dongbu.Model.Sdo.ProductCdo;
import com.kjb.dongbu.Repository.Store.ProductStore;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductStore productStore;

    public ProductService(ProductStore productStore){
        this.productStore = productStore;
    }

    public String registerProduct(ProductCdo productCdo){
        Product product = new Product(productCdo);

        productStore.save(product);
        return product.getP_code();
    }

    public List<Product> findMembersByName () {
        return productStore.findAll();
    }
}
