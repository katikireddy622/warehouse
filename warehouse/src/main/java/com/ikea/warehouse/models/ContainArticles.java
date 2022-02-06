package com.ikea.warehouse.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class ContainArticles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artId_artId")
    private Articles artId;

    private long amount_of;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Products products;


    public ContainArticles(Long id, Articles artId, long amount_of, Products products) {
        this.id = id;
        this.artId = artId;
        this.amount_of = amount_of;
        this.products = products;
    }

    public ContainArticles() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Articles getArtId() {
        return artId;
    }

    public void setArtId(Articles artId) {
        this.artId = artId;
    }

    public long getAmount_of() {
        return amount_of;
    }

    public void setAmount_of(long amount_of) {
        this.amount_of = amount_of;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
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
        ContainArticles that = (ContainArticles) o;
        return amount_of == that.amount_of && Objects.equals(id, that.id) && Objects.equals(artId, that.artId) && Objects.equals(products, that.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, artId, amount_of, products);
    }

    @Override
    public String toString() {
        return "ContainArticles{" +
                "id=" + id +
                ", artId=" + artId +
                ", amount_of=" + amount_of +
                ", products=" + products +
                '}';
    }
}
