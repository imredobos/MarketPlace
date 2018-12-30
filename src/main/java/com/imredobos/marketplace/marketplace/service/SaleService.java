package com.imredobos.marketplace.marketplace.service;

import com.imredobos.marketplace.marketplace.entity.Product;
import com.imredobos.marketplace.marketplace.entity.Sale;
import com.imredobos.marketplace.marketplace.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    public void saveSale(Product product, Integer unit) {
        Sale sale = new Sale();
        sale.setProduct(product);
        sale.setUnit(unit);
        sale.setValue(product.getPrice());
        saleRepository.save(sale);
    }
}
