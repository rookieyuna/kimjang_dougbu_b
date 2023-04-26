package com.kjb.dongbu.Controller;

import com.kjb.dongbu.Model.Member;
import com.kjb.dongbu.Model.Product;
import com.kjb.dongbu.Model.Sdo.MemberCdo;
import com.kjb.dongbu.Model.Sdo.MemberUdo;
import com.kjb.dongbu.Model.Sdo.ProductCdo;
import com.kjb.dongbu.Model.Sdo.ProductUdo;
import com.kjb.dongbu.Service.MemberService;
import com.kjb.dongbu.Service.ProductService;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

//    @PostMapping("")
//    public String registerProduct(@RequestBody ProductCdo productCdo) {
//        return productService.registerProduct(productCdo);
//    }

    @GetMapping("/all")
    public List<Product> findProducts() {
        return productService.findProducts();
    }

    @GetMapping("")
    public List<Product> findProductsByHtCode(@RequestParam String htCode) {
        return productService.findProductsByHtCode(htCode);
    }

    @PutMapping("")
    public void modifyProduct(@RequestBody ProductUdo productUdo) {
        productService.modifyProduct(productUdo);
    }

    @DeleteMapping("")
    public void removeProduct(@RequestParam String pdCode) {
        productService.removeProduct(pdCode);
    }
}