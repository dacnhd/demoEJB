package com.example.demoejb.controller;

import com.example.demoejb.entity.Product;
import com.example.demoejb.entity.Sale;
import com.example.demoejb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model){
        model.addAttribute("list", productService.getList());
        return "admin/products/index";
    }

    @RequestMapping(value = "/listsale", method = RequestMethod.GET)
    public String getListSale(Model model){
        model.addAttribute("listsale", productService.getListSale());
        return "admin/products/listsale";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(){
        productService.createPro(new Product("A001", "aaa1", "aaabbbccc", "10-11-12", 111));
        productService.createPro(new Product("A002", "aaa2", "aaabbbccc", "11-10-12", 123));
        productService.createPro(new Product("A003", "aaa3", "aaabbbccc", "15-11-12", 134));
        productService.createPro(new Product("A004", "aaa4", "aaabbbccc", "9-12-12", 145));

        productService.createSale(new Sale("Id001", "dac", "11-11-11", "A001"));
        productService.createSale(new Sale("Id002", "dacnhd", "12-11-11", "A001"));
        productService.createSale(new Sale("Id001", "dac", "11-12-11", "A003"));
        productService.createSale(new Sale("Id001", "dac", "10-12-11", "A003"));
        return "admin/products/index";
    }
}
