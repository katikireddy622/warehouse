package com.ikea.warehouse.models.json;

import java.util.Objects;

public class CustomArticlesJson{
    private long art_id;
    private long amount_of;

    public long getArt_id() {
        return art_id;
    }

    public void setArt_id(long art_id) {
        this.art_id = art_id;
    }

    public long getAmount_of() {
        return amount_of;
    }

    public void setAmount_of(long amount_of) {
        this.amount_of = amount_of;
    }

    public CustomArticlesJson(long art_id, long amount_of) {
        this.art_id = art_id;
        this.amount_of = amount_of;
    }

    public CustomArticlesJson() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CustomArticlesJson that = (CustomArticlesJson) o;
        return art_id == that.art_id && amount_of == that.amount_of;
    }

    @Override
    public int hashCode() {
        return Objects.hash(art_id, amount_of);
    }
}
