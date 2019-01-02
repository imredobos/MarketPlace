package com.imredobos.marketplace.service.impl;

import com.imredobos.marketplace.entity.Product;
import com.imredobos.marketplace.entity.Sale;
import com.imredobos.marketplace.repository.SaleRepository;
import com.imredobos.marketplace.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleServiceImpl implements SaleService {

    private SaleRepository saleRepository;

    @Autowired
    public SaleServiceImpl(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    @Override
    public void saveSale(Product product, Integer unit) {
        Sale sale = new Sale();
        sale.setProduct(product);
        sale.setUnit(unit);
        sale.setValue(calculateSaleValue(unit, product.getPrice()));
        saleRepository.save(sale);
    }

    private int calculateSaleValue(int unit, int price) {
        return unit * price;
    }
}
