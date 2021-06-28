package com.example.demoejb.service;

import com.example.demoejb.entity.Product;
import com.example.demoejb.entity.Sale;
import com.example.demoejb.repository.ProductRepository;
import com.example.demoejb.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SaleRepository saleRepository;

    public Product createPro(Product product){
        return productRepository.save(product);
    }

    public List<Product> getList(){
        return productRepository.findAll();
    }

    public Sale createSale(Sale sale){
        if (productRepository.findById(sale.getProdID()).isPresent()){
            sale.setProduct(productRepository.findById(sale.getProdID()).get());
            return saleRepository.save(sale);
        }
        return null;
    }

    public List<Sale> getListSale(){
        return saleRepository.findAll();
    }
}
