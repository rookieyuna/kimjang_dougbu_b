package com.kjb.dongbu.Service;

import com.kjb.dongbu.Model.Member;
import com.kjb.dongbu.Model.Product;
import com.kjb.dongbu.Model.Sdo.MemberUdo;
import com.kjb.dongbu.Model.Sdo.ProductCdo;
import com.kjb.dongbu.Model.Sdo.ProductUdo;
import com.kjb.dongbu.Repository.Store.ProductStore;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ProductService {
    private final ProductStore productStore;

    public ProductService(ProductStore productStore){
        this.productStore = productStore;
    }

    public String registerProduct(ProductCdo productCdo){
        Product product = new Product(productCdo);

        product.setPdCode(productCdo.getHtCode()+'_'+productCdo.getLabel());

        productStore.save(product);
        return product.getPdCode();
    }

    public List<Product> findProducts () {
        return productStore.findAll();
    }

    public Product findProductById (String pdCode) {
        return productStore.findById(pdCode);
    }

    public List<Product> findProductsByHtCode (String htCode) {
        return productStore.findByHtCode(htCode);
    }

    public void modifyProduct (ProductUdo productUdo){
        Product product = productStore.findById(productUdo.getPdCode());

        if (Objects.equals(product.getPdCode(), productUdo.getPdCode())) {
            product.setProductType(productUdo.getProductType());
            product.setProductEtc(productUdo.getProductEtc());
            product.setRepairType(productUdo.getRepairType());
            product.setTextureType(productUdo.getTextureType());
            product.setSizeType(productUdo.getSizeType());
            product.setColor(productUdo.getColor());
            product.setPremiumYn(productUdo.getPremiumYn());
            product.setPrice(productUdo.getPrice());
        }
        productStore.save(product);
    }

    public void removeProduct(String pdCode) {
        productStore.deleteById(pdCode);
    }
}
