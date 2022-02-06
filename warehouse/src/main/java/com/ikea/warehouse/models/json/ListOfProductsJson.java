package com.ikea.warehouse.models.json;

import java.util.List;
import java.util.Objects;

public class ListOfProductsJson {
    private List<ProductsJson> products;

    public ListOfProductsJson(List<ProductsJson> products) {
        this.products = products;
    }

    public List<ProductsJson> getProducts() {
        return products;
    }

    public void setProducts(List<ProductsJson> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ListOfProductsJson that = (ListOfProductsJson) o;
        return Objects.equals(products, that.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(products);
    }

    @Override
    public String toString() {
        return "ListOfProductsJson{" +
                "products=" + products +
                '}';
    }

    public ListOfProductsJson() {
    }
}
