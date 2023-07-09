import model.Category;
import model.Film;
import model.Platform;
import model.ShowTime;
import service.CategoryService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Admin {
    public void adminLoop(List<Film> filmList, List<Category> categoryList, Scanner input){
        CategoryService categoryService = new CategoryService(); // Film Servisleri için oluşturulan nesne
        List<Category> filmCategoryList = new ArrayList<>(); // Film eklerken kategorileri tutan liste
        List<Platform> filmPlatformList = new ArrayList<>(); // Film eklerken platformları tutan liste
        List<ShowTime> filmShowTimeList = new ArrayList<>(); // Film eklerken seansları tutan liste

        while(true) { // Kategori döngüsü
            System.out.println("Kategori ismi girin.");
            String categoryName = input.nextLine();
            Category category;

            if(categoryService.findCategory(categoryList, categoryName)) { // Eğer kategori zaten varsa
                category = categoryService.returnCategory(categoryList, categoryName); // Kategoriyi genel listeden bul

                if(!filmCategoryList.contains(category)) { // Eğer filmin kategori listesine daha önce eklenmemişse ekle
                    filmCategoryList.add(category);
                }
            } else { // Eğer kategori yoksa
                category = new Category(categoryName); // Kategori yarat
                categoryList.add(category); // Genel kategori listesine ekle
                filmCategoryList.add(category); // Filmin kategori listesine ekle
            }

            System.out.println("Başka kategori eklemek istiyor musunuz? (E/H)");
            String answer = input.nextLine();
            if(answer.equalsIgnoreCase("H")) {
                break;
            } else if(!answer.equalsIgnoreCase("E")) {
                System.out.println("Hatalı giriş yaptınız.");
                break;
            }
        }

        while (true) {
            System.out.println("Platform ismi girin.");
            String platformName = input.nextLine();
            Platform platform = new Platform(platformName);
            filmPlatformList.add(platform);

            System.out.println("Başka platform eklemek istiyor musunuz? (E/H)");
            String answer = input.nextLine();

            if(answer.equalsIgnoreCase("H")) {
                break;
            } else if(!answer.equalsIgnoreCase("E")) {
                System.out.println("Hatalı giriş yaptınız.");
                break;
            }
        }

        // Filmin geri kalan bilgilerini al
        System.out.println("Film ismi girin.");
        String filmName = input.nextLine();
        System.out.println("Yönetmen ismi girin.");
        String directorName = input.nextLine();
        System.out.println("Yapım yılı girin.");
        int productionYear = Integer.parseInt(input.nextLine());

        // Seans döngüsü
        while (true) {
            System.out.println("Seans saatini girin.");
            String showTime = input.nextLine();
            ShowTime showTimeObj = new ShowTime(showTime);
            filmShowTimeList.add(showTimeObj);

            System.out.println("Başka seans eklemek istiyor musunuz? (E/H)");
            String answer = input.nextLine();

            if(answer.equalsIgnoreCase("H")) {
                break;
            } else if(!answer.equalsIgnoreCase("E")) {
                System.out.println("Hatalı giriş yaptınız.");
                break;
            }
        }

        // Film nesnesini yarat
        Film film = new Film(filmCategoryList, filmPlatformList, filmName, directorName, productionYear, filmShowTimeList);
        filmList.add(film); // Genel film listesine ekle
        categoryService.updateCategoryFilmCount(filmList, filmCategoryList); // Kategorilerin film sayılarını güncelle
        System.out.print("\n");
    }
}
