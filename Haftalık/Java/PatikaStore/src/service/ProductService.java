package service;

import model.*;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ProductService {

    PrintService printService = new PrintService();
    Scanner scanner = new Scanner(System.in);

    public void listProductsByCategory(Store store, String category) {
        if (category.equalsIgnoreCase("Notebook")) {
            List<Product> notebookList = store.getProductList().stream()
                    .filter(product -> product instanceof Notebook)
                    .collect(Collectors.toList());
            printService.printProductTable(notebookList, false);
        } else if (category.equalsIgnoreCase("Phone")) {
            List<Product> phoneList = store.getProductList().stream()
                    .filter(product -> product instanceof Phone)
                    .collect(Collectors.toList());
            printService.printProductTable(phoneList, true);
        } else {
            System.out.println("Geçersiz tercih! Tekrar deneyin.");
        }
    }

    public void addProduct(Store store, Product product) {
        store.getProductList().add(product);
        System.out.println("Ürün başarıyla eklendi.");
    }

    public void deleteProductByUniqueId(Store store, int uniqueId) {
        List<Product> productList = store.getProductList();
        boolean removed = productList.removeIf(product -> product.getId() == uniqueId);

        if (removed) {
            System.out.println("Ürün başarıyla silindi.");
        } else {
            System.out.println("Böyle bir benzersiz numaraya sahip ürün bulunamadı.");
        }
    }

    public void filterProductsByUniqueId(Store store) {
        System.out.println("Kategori seçiniz:");
        System.out.println("1 - Notebook");
        System.out.println("2 - Cep Telefonu");
        System.out.print("Tercihiniz: ");
        int categoryChoice = Integer.parseInt(scanner.nextLine());

        System.out.print("Ürün ID'sini giriniz: ");
        int uniqueId = Integer.parseInt(scanner.nextLine());

        if (categoryChoice == 1) {
            for (Product product : store.getProductList()) {
                if (product.getId() == uniqueId && product instanceof Notebook) {
                    printService.printProductTable(List.of(product), false);
                    return;
                }
            }
        } else if (categoryChoice == 2) {
            for (Product product : store.getProductList()) {
                if (product.getId() == uniqueId && product instanceof Phone) {
                    printService.printProductTable(List.of(product), true);
                    return;
                }
            }
        } else {
            System.out.println("Geçersiz tercih! Tekrar deneyin.");
        }
    }

    public void filterProductsByBrand(Store store) {
        System.out.println("Kategori seçiniz:");
        System.out.println("1 - Notebook");
        System.out.println("2 - Cep Telefonu");
        System.out.print("Tercihiniz: ");
        int categoryChoice = Integer.parseInt(scanner.nextLine());
        System.out.println("Marka seçiniz:");
        for (int i = 0; i < store.getBrandList().size(); i++) {
            System.out.println(i + "- " + store.getBrandList().get(i).getName());
        }
        int brand = Integer.parseInt(scanner.nextLine());

        if (categoryChoice == 1) {
            for (Product product : store.getProductList()) {
                if (product.getBrand().getName().equalsIgnoreCase(store.getBrandList().get(brand).getName()) && product instanceof Notebook) {
                    printService.printProductTable(List.of(product), false);
                    return;
                }
            }
        } else if (categoryChoice == 2) {
            for (Product product : store.getProductList()) {
                if (product.getBrand().getName().equalsIgnoreCase(store.getBrandList().get(brand).getName()) && product instanceof Phone) {
                    printService.printProductTable(List.of(product), true);
                    return;
                }
            }
        } else {
            System.out.println("Geçersiz tercih! Tekrar deneyin.");
        }
    }

    public void addProduct(Store store) {

        System.out.println("Ürün eklemek için kategori seçiniz:");
        System.out.println("1 - Notebook");
        System.out.println("2 - Cep Telefonu");
        System.out.print("Tercihiniz: ");
        int categoryChoice = Integer.parseInt(scanner.nextLine());

        if (categoryChoice == 1) {
            System.out.print("Ürün adı: ");
            String name = scanner.nextLine();
            System.out.print("Marka: ");
            for (int i = 0; i < store.getBrandList().size(); i++) {
                System.out.println(i + "- " + store.getBrandList().get(i).getName());
            }
            String brandChoice = scanner.nextLine();
            Brand brand = store.getBrandList().get(Integer.parseInt(brandChoice));

            System.out.print("Depolama: ");
            int storage = Integer.parseInt(scanner.nextLine());

            System.out.print("Ekran boyutu: ");
            double screenSize = Double.parseDouble(scanner.nextLine());

            System.out.print("RAM: ");
            int ram = Integer.parseInt(scanner.nextLine());

            System.out.print("Fiyat: ");
            int price = Integer.parseInt(scanner.nextLine());

            System.out.print("Stok adedi: ");
            int stock = Integer.parseInt(scanner.nextLine());

            System.out.print("İndirim oranı: ");
            int discount = Integer.parseInt(scanner.nextLine());

            addProduct(store, new Notebook(
                    store.getProductList().size() + 1,
                    price,
                    discount,
                    stock,
                    name,
                    brand,
                    ram,
                    storage,
                    screenSize
            ));
        } else if (categoryChoice == 2) {
            System.out.print("Ürün adı: ");
            String name = scanner.nextLine();
            System.out.print("Marka: ");
            for (int i = 0; i < store.getBrandList().size(); i++) {
                System.out.println(i + "- " + store.getBrandList().get(i).getName());
            }
            String brandChoice = scanner.nextLine();
            Brand brand = store.getBrandList().get(Integer.parseInt(brandChoice));

            System.out.print("Depolama: ");
            int storage = Integer.parseInt(scanner.nextLine());

            System.out.print("Ekran boyutu: ");
            double screenSize = Double.parseDouble(scanner.nextLine());

            System.out.print("RAM: ");
            int ram = Integer.parseInt(scanner.nextLine());

            System.out.print("Batarya gücü: ");
            int batteryPower = Integer.parseInt(scanner.nextLine());

            System.out.print("Renk: ");
            String color = scanner.nextLine();

            System.out.print("Fiyat: ");
            int price = Integer.parseInt(scanner.nextLine());

            System.out.print("Stok adedi: ");
            int stock = Integer.parseInt(scanner.nextLine());

            System.out.print("İndirim oranı: ");
            int discount = Integer.parseInt(scanner.nextLine());

            addProduct(store, new Phone(
                    store.getProductList().size() + 1,
                    price,
                    discount,
                    stock,
                    name,
                    brand,
                    storage,
                    screenSize,
                    batteryPower,
                    ram,
                    color
            ));
        } else {
            System.out.println("Geçersiz tercih! Tekrar deneyin.");
        }
    }

    public void deleteProduct(Store store) {
        System.out.println("Ürün silmek için kategori seçiniz:");
        System.out.println("1 - Notebook");
        System.out.println("2 - Cep Telefonu");
        System.out.print("Tercihiniz: ");
        int categoryChoice = Integer.parseInt(scanner.nextLine());

        if (categoryChoice == 1) {
            System.out.print("Silmek istediğiniz ürünün ID'sini giriniz: ");
            int id = Integer.parseInt(scanner.nextLine());
            deleteProductByUniqueId(store, id);
        } else if (categoryChoice == 2) {
            System.out.print("Silmek istediğiniz ürünün ID'sini giriniz: ");
            int id = Integer.parseInt(scanner.nextLine());
            deleteProductByUniqueId(store, id);
        } else {
            System.out.println("Geçersiz tercih! Tekrar deneyin.");
        }
    }

}
