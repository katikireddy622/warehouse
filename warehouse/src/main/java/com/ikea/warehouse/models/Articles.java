package com.ikea.warehouse.models;


import javax.persistence.*;

@Entity
public class Articles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "art_id")
    private long artId;
    private String name;
    private long stock;

    public long getArtId() {
        return artId;
    }

    public void setArtId(long art_id) {
        this.artId = art_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getStock() {
        return stock;
    }

    public void setStock(long stock) {
        this.stock = stock;
    }

    public Articles(long art_id, String name, int stock) {
        this.artId = art_id;
        this.name = name;
        this.stock = stock;
    }

    public Articles() {
    }

    @Override
    public String toString() {
        return "Articles{" +
                "artId=" + artId +
                ", name='" + name + '\'' +
                ", stock=" + stock +
                '}';
    }
}
