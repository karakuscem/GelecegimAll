package service;

import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StoreService {
    public Store createStore(){
        Store store = new Store(initializeBrands());
        store.setProductList(initializeProducts(store));
        return store;
    }
    private List<Brand> initializeBrands() {
        List<Brand> brandList = new ArrayList<>();
        brandList.add(new Brand(1, "Samsung"));
        brandList.add(new Brand(2, "Lenovo"));
        brandList.add(new Brand(3, "Apple"));
        brandList.add(new Brand(4, "Huawei"));
        brandList.add(new Brand(5, "Casper"));
        brandList.add(new Brand(6, "Asus"));
        brandList.add(new Brand(7, "HP"));
        brandList.add(new Brand(8, "Xiaomi"));
        brandList.add(new Brand(9, "Monster"));

        return brandList;
    }

    private List<Product> initializeProducts(Store store) {
        List<Product> productList = new ArrayList<>();
        productList.add(new Phone(1, 10000, 10, 100, "Samsung Galaxy S20",
                store.getBrandList().get(0), 128, 6.2, 8, 4000, "Siyah"));
        productList.add(new Phone(2, 8000, 10, 100, "Samsung Galaxy S20 Ultra",
                store.getBrandList().get(0), 128, 6.9, 12, 5000, "Gri"));
        //Lenovo
        productList.add(new Phone(3, 5000, 10, 100, "Lenovo K6",
                store.getBrandList().get(1), 32, 5.0, 3, 3000, "Siyah"));
        //Apple
        productList.add(new Phone(4, 15000, 10, 100, "iPhone 11 Pro",
                store.getBrandList().get(2), 128, 5.8, 4, 3190, "Siyah"));
        productList.add(new Phone(5, 12000, 10, 100, "iPhone 11",
                store.getBrandList().get(2), 64, 6.1, 4, 3110, "Beyaz"));
        // Notebooks
        productList.add(new Notebook(6, 10000, 10, 100, "Lenovo V15",
                store.getBrandList().get(1), 8, 512, 15.6));
        productList.add(new Notebook(7, 15000, 10, 100, "Lenovo V14",
                store.getBrandList().get(1), 8, 256, 14.0));
        //Apple notebooks
        productList.add(new Notebook(8, 20000, 10, 100, "MacBook Pro",
                store.getBrandList().get(2), 16, 512, 13.3));
        productList.add(new Notebook(9, 25000, 10, 100, "MacBook Air",
                store.getBrandList().get(2), 16, 512, 13.3));
        //Huawei notebooks
        productList.add(new Notebook(10, 15000, 10, 100, "MateBook D 15",
                store.getBrandList().get(3), 8, 256, 15.6));
        productList.add(new Notebook(11, 10000, 10, 100, "MateBook D 14",
                store.getBrandList().get(3), 8, 256, 14.0));
        //Casper notebooks
        productList.add(new Notebook(12, 10000, 10, 100, "Nirvana X500",
                store.getBrandList().get(4), 8, 256, 15.6));
        // Asus notebooks
        productList.add(new Notebook(13, 10000, 10, 100, "VivoBook 15",
                store.getBrandList().get(5), 8, 256, 15.6));
        // HP notebooks
        productList.add(new Notebook(14, 10000, 10, 100, "Pavilion 15",
                store.getBrandList().get(6), 8, 256, 15.6));
        // Xiaomi notebooks
        productList.add(new Notebook(15, 10000, 10, 100, "Mi Notebook Pro",
                store.getBrandList().get(7), 8, 256, 15.6));
        // Monster notebooks
        productList.add(new Notebook(16, 10000, 10, 100, "Abra A5 V15.6.1",
                store.getBrandList().get(8), 8, 256, 15.6));
        return productList;
    }
}
