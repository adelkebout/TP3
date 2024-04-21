package org.example;

import org.example.ProductApiClient;
import org.example.Produit;

public class ProductService {
    private ProductApiClient productApiClient;

    public ProductService(ProductApiClient productApiClient) {
        this.productApiClient = productApiClient;
    }

    public Produit getProduct(String productId) {
        return productApiClient.getProduct(productId);
    }
}