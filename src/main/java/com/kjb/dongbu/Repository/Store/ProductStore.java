package com.kjb.dongbu.Repository.Store;

import com.kjb.dongbu.Model.Product;
import com.kjb.dongbu.Repository.Jpo.ProductJpo;
import com.kjb.dongbu.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductStore {

    @Autowired
    private ProductRepository productRepository;

    public void save(Product product) {
        ProductJpo productJpo = new ProductJpo(product);
        productRepository.save(productJpo);
    }

    public Product findById(long p_code) {
        Optional<ProductJpo> optionalProductJpo = productRepository.findById(p_code);
        return optionalProductJpo.map(ProductJpo::toDomain).orElse(null);
    }

    public List<Product> findAll() {
        List<ProductJpo> productJpos = productRepository.findAll();
        return ProductJpo.toDomains(productJpos);
    }

    public void deleteById(long p_code) {
        productRepository.deleteById(p_code);
    }
}
