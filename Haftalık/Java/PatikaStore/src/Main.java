import model.Brand;
import model.Notebook;
import model.Phone;
import model.Store;
import service.ProductService;
import service.StoreService;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        StoreService storeService = new StoreService();
        Store store = storeService.createStore();
        ProductService productService = new ProductService();
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("\nPatikaStore Ürün Yönetim Paneli !");
            System.out.println("1 - Notebook Listesi");
            System.out.println("2 - Cep Telefonu Listesi");
            System.out.println("3 - Marka Listesi");
            System.out.println("4 - Ürün Ekle");
            System.out.println("5 - Ürün Sil");
            System.out.println("6 - Ürünleri Markaya Göre Filtrele");
            System.out.println("7 - Ürünleri ID'ye Göre Filtrele");
            System.out.println("0 - Çıkış Yap");
            System.out.print("Tercihiniz: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> {
                    System.out.println("Notebook Listesi\n");
                    productService.listProductsByCategory(store, "Notebook");

                }
                case 2 -> {
                    System.out.println("Cep Telefonu Listesi\n");
                    productService.listProductsByCategory(store, "Phone");
                }
                case 3 -> {
                    System.out.println("Markalarımız\n");
                    System.out.println("--------------");
                    for (Brand brand : store.getBrandList()) {
                        System.out.println("- " + brand.getName());
                    }
                }
                case 4 ->
                    productService.addProduct(store);
                case 5 ->
                    productService.deleteProduct(store);
                case 6 ->
                    productService.filterProductsByBrand(store);
                case 7 ->
                    productService.filterProductsByUniqueId(store);
                case 0 -> System.out.println("Çıkış yapılıyor...");
                default -> System.out.println("Geçersiz tercih! Tekrar deneyin.");
            }
        } while (choice != 0);
    }
}