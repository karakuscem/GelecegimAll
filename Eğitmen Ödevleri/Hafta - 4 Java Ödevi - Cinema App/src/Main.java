import model.Category;
import model.Film;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Film> filmList = new ArrayList<>(); // Filmlerin hepsinin tutulduğu liste
        List<Category> categoryList = new ArrayList<>(); // Filmleri eklerken yaratılan kategoriler
        Admin admin = new Admin(); // Admin için oluşturulan nesne
        User user = new User(); // User için oluşturulan nesne
        Scanner input = new Scanner(System.in); // Input için gerekli
        while (true)
        {
            System.out.println("Kullanıcı seçin.\nAdmin için: 1\nKullanıcı için: 2\nÇıkış için: 3");
            int inputNum = Integer.parseInt(input.nextLine());

            switch (inputNum) {
                case 1 -> admin.adminLoop(filmList, categoryList, input);
                case 2 -> user.userLoop(categoryList, filmList, input);
                case 3 -> System.exit(0);
                default -> System.out.println("Hatalı giriş yaptınız.");
            }
        }
    }
}