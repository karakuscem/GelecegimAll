package service;

import model.Notebook;
import model.Phone;
import model.Product;

import java.util.List;

public class PrintService {
    public void printProductTable(List<Product> productList, boolean isPhone) {
        if (isPhone) {
            printTableHeaderPhone();
            for (Product product : productList) {
                if (product instanceof Phone) {
                    printTablePhone((Phone) product);
                }
            }
        } else {
            printTableHeaderNotebook();
            for (Product product : productList) {
                if (product instanceof Notebook) {
                    printTableNotebook((Notebook) product);
                }
            }
        }
    }

    public void printTableHeaderPhone() {
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.printf("| %-5s | %-20s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s |%n",
                "ID", "Ürün Adı", "Marka", "Depolama", "Ekran Boyutu", "RAM", "Batarya", "Renk", "Fiyat");
        System.out.println("-------------------------------------------------------------------------------------------");
    }

    public void printTablePhone(Phone phone) {
        System.out.printf("| %-5d | %-20s | %-10s | %-10d | %-13.1f | %-4d | %-8d | %-10s | %-10d |%n",
                phone.getId(), phone.getName(), phone.getBrand().getName(), phone.getStorage(),
                phone.getScreenSize(), phone.getRam(), phone.getBatteryPower(),
                phone.getColor(), phone.getPrice());
    }

    public void printTableHeaderNotebook() {
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.printf("| %-5s | %-20s | %-10s | %-10s | %-10s | %-10s | %-10s |%n",
                "ID", "Ürün Adı", "Marka", "Depolama", "Ekran Boyutu", "RAM", "Fiyat");
        System.out.println("-------------------------------------------------------------------------------------------");
    }

    public void printTableNotebook(Notebook notebook) {
        System.out.printf("| %-5d | %-20s | %-10s | %-10d | %-13.1f | %-4d | %-10d |%n",
                notebook.getId(), notebook.getName(), notebook.getBrand().getName(), notebook.getStorage(),
                notebook.getScreenSize(), notebook.getRam(), notebook.getPrice());
    }
}
