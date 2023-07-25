package model;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private final String name = "Patika Store";

    private List<Brand> brandList = new ArrayList<>();

    private List<Product> productList = new ArrayList<>();

    public Store(List<Brand> brandList) {
        this.brandList = brandList;
    }

    public String getName() {
        return name;
    }

    public List<Brand> getBrandList() {
        return brandList;
    }

    public void setBrandList(List<Brand> brandList) {
        this.brandList = brandList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
