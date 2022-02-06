package com.ikea.warehouse.controllers;

import com.ikea.warehouse.models.Articles;
import com.ikea.warehouse.models.ContainArticles;
import com.ikea.warehouse.models.Products;
import com.ikea.warehouse.models.json.ListOfProductsJson;
import com.ikea.warehouse.models.json.ProductsJson;
import com.ikea.warehouse.repository.ContainArticlesRepository;
import com.ikea.warehouse.repository.InventoryRepository;
import com.ikea.warehouse.repository.ProductsRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@RestController
@RequestMapping("/products")
public class ProductsController {

    final
    ProductsRepository productsRepository;

    final
    InventoryRepository inventoryRepository;

    final
    ContainArticlesRepository containArticlesRepository;

    public ProductsController(ProductsRepository productsRepository, InventoryRepository inventoryRepository, ContainArticlesRepository containArticlesRepository) {
        this.productsRepository = productsRepository;
        this.inventoryRepository = inventoryRepository;
        this.containArticlesRepository = containArticlesRepository;
    }

    @PostMapping(path = "/saveList",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Products> saveOrUpdate(@RequestBody ListOfProductsJson listOfProductsJson)
    {
        List<Products> products=new ArrayList<>();
        listOfProductsJson.getProducts().forEach(productsJson -> {
         products.add(productsRepository.save(convertProductJsonIntoProduct(productsJson)));
        });
        return products;
    }
    @PostMapping(path = "/save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public Products saveOrUpdate(@RequestBody ProductsJson productsJson)
    {
        return productsRepository.save(convertProductJsonIntoProduct(productsJson));
    }

    private Products convertProductJsonIntoProduct(ProductsJson productsJson)
    {
        Products product=new Products();
        product.setName(productsJson.getName());
        List<ContainArticles> listOfContainArticles=new ArrayList<>();
        productsJson.getContain_articles().forEach(customArticlesJson -> {
            ContainArticles containArticles=new ContainArticles();
            containArticles.setArtId(inventoryRepository.getById(customArticlesJson.getArt_id()));
            containArticles.setAmount_of(customArticlesJson.getAmount_of());
            listOfContainArticles.add(containArticles);
        });
        product.setContainArticles(listOfContainArticles);
        System.out.println(product);
        return product;
    }

    @GetMapping(value = "/getAll",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Products> getAllProductsWithInventoryInfo()
    {
        return productsRepository.findAll();
    }

    @GetMapping(value = "/sell/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public String sellProductBasedOnInventory(@PathVariable("id") Long productId)
    {
         Products product=productsRepository.findById(productId).get();
        AtomicBoolean flag= new AtomicBoolean(false);
         product.getContainArticles().forEach(containArticles -> {
            if(containArticles.getAmount_of()>containArticles.getArtId().getStock())
            {
                flag.set(true);
            }
        });

         if(flag.get()){
             return "The stock is not available so product can't be sold";
         }
         else {
            // removing the stock from inventory
             product.getContainArticles().forEach(containArticles -> {
                 long artId=containArticles.getArtId().getArtId();
                 long amountOf=containArticles.getAmount_of();
                 Articles article=inventoryRepository.getById(artId);
                 long articleStock=article.getStock();
                 article.setStock(articleStock-amountOf);
                 inventoryRepository.save(article);
             });

             productsRepository.deleteById(productId);
             return productId+" is Sold";
         }
    }

}
