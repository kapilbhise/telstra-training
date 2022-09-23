package com.programming.SpringBootConcepts.SpringMVCWithSpringBoot.restcotrollers;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.programming.SpringBootConcepts.SpringMVCWithSpringBoot.beans.Product;
import com.programming.SpringBootConcepts.SpringMVCWithSpringBoot.repository.ProductRepository;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductRestController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/hplus/rest/products")
    @ResponseBody
    public List<Product> getProducts(){
        List<Product> products= new ArrayList<>();
        productRepository.findAll().forEach(product -> products.add(product));
//        products.stream().forEach(product -> System.out.println(product.getName()));
        return products;
    }

//    e.g. localhost:8080/hplus/rest/product?name=berry
    // query paranmeter ?name=
    @GetMapping("/hplus/rest/product")
    public ResponseEntity getProductByRequestParam(@RequestParam("name") String name){
        List<Product> products= productRepository.searchByName(name);
        return  new ResponseEntity(products, HttpStatus.OK);
    }

//    e.g. localhost:8080/hplus/rest/products/berry
    // path variable /{name}
    @GetMapping("/hplus/rest/products/{name}")
    public ResponseEntity getProductByPathVariable(@PathVariable("name") String name){
        List<Product> products= productRepository.searchByName(name);

        return  new ResponseEntity(products, HttpStatus.OK);
    }
}
