package com.ikea.warehouse.models.json;

import java.util.List;
import java.util.Objects;

public class ProductsJson {
    private String name;
    private List<CustomArticlesJson> contain_articles;

    public ProductsJson(String name, List<CustomArticlesJson> contain_articles) {
        this.name = name;
        this.contain_articles = contain_articles;
    }

    public ProductsJson() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CustomArticlesJson> getContain_articles() {
        return contain_articles;
    }

    public void setContain_articles(List<CustomArticlesJson> contain_articles) {
        this.contain_articles = contain_articles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProductsJson that = (ProductsJson) o;
        return Objects.equals(name, that.name) && Objects.equals(contain_articles, that.contain_articles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, contain_articles);
    }

    @Override
    public String toString() {
        return "ProductsJson{" +
                "name='" + name + '\'' +
                ", contain_articles=" + contain_articles +
                '}';
    }
}
