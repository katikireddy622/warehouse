package com.ikea.warehouse.models.json;

import com.ikea.warehouse.models.Articles;

import java.util.List;
import java.util.Objects;

public class InventoryJson {
    private List<Articles>  inventory;

    public List<Articles> getInventory() {
        return inventory;
    }

    public void setInventory(List<Articles> inventory) {
        this.inventory = inventory;
    }

    public InventoryJson(List<Articles> inventory) {
        this.inventory = inventory;
    }

    public InventoryJson() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        InventoryJson that = (InventoryJson) o;
        return Objects.equals(inventory, that.inventory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inventory);
    }

    @Override
    public String toString() {
        return "InventoryJson{" +
                "inventory=" + inventory +
                '}';
    }
}
