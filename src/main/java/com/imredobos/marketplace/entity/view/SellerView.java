package com.imredobos.marketplace.entity.view;

public class SellerView {
    public interface Summary {}
    public interface WithProducts extends Summary{}
    public interface WithRates extends Summary {}
    public interface WithProductsAndRates extends WithProducts, WithRates {}
}
