package com.ikea.warehouse.models;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Products{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "products_id")
    private List<ContainArticles> containArticles;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ContainArticles> getContainArticles() {
        return containArticles;
    }

    public void setContainArticles(List<ContainArticles> contain_articles) {
        this.containArticles = contain_articles;
    }

    public Products() {
    }

    public Products(long id, String name, List<ContainArticles> contain_articles) {
        this.id = id;
        this.name = name;
        this.containArticles = contain_articles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Products products = (Products) o;
        return id == products.id && Objects.equals(name, products.name) && Objects.equals(containArticles, products.containArticles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, containArticles);
    }

    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", containArticles=" + containArticles +
                '}';
    }
}
