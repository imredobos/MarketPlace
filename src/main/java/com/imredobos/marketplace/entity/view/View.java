package com.imredobos.marketplace.entity.view;

public class View {
    public interface Summary {
    }

    public interface WithSales extends Summary {
    }

    public interface WithProduct extends Summary {
    }

    public interface WithProductAndSales extends WithSales, WithProduct {
    }

    public interface WithRates extends Summary {
    }
}
