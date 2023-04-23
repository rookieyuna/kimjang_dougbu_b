package com.kjb.dongbu.Repository;


import com.kjb.dongbu.Repository.Jpo.ProductJpo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProductRepository extends JpaRepository<ProductJpo, String> {
    List<ProductJpo> findByHtCode(String htCode);
}


