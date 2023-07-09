import model.Category;
import model.Film;
import model.Platform;
import model.ShowTime;

import java.util.List;
import java.util.Scanner;

public class User {
    public void userLoop(List<Category> categoryList, List<Film> filmList, Scanner input) {
        // Kategorileri listele
        System.out.println("\nGörüntülemek istediğiniz kategoriyi seçin.");
        for (int i = 0; i < categoryList.size(); i++) {
            System.out.println((i + 1) + ". " + categoryList.get(i).getCategoryName() + " (" + categoryList.get(i).getFilmCount() + " film)");
        }
        // Seçilen kategorinin bilgisini al
        int categoryNum = Integer.parseInt(input.nextLine());
        Category category = categoryList.get(categoryNum - 1);
        System.out.println("\n" +category.getCategoryName() + " kategorisinde " + category.getFilmCount() + " film bulunmaktadır.");

        // Film listesinde bulunan tüm filmleri dolaş
        for (Film film : filmList) {
            // Film kategorilerini dolaş
            for (Category filmCategory : film.getCategoryList()) {
                // Eğer film kategorisi seçilen kategoriyle aynıysa
                if (filmCategory.getCategoryName().equals(category.getCategoryName())) {
                    // Film bilgilerini yazdır
                    System.out.println("\nFilm İsmi: " + film.getFilmName());
                    System.out.println("Yönetmen İsmi: " + film.getDirectorName());
                    System.out.println("Yapım Yılı: " + film.getPublishYear());
                    System.out.print("Kategoriler: ");
                    // Film kategorilerini yazdır döngü ile
                    for (Category filmCategory1 : film.getCategoryList()) {
                        System.out.print(filmCategory1.getCategoryName() + ", ");
                    }
                    System.out.print("\n");
                    System.out.print("Platformlar: ");
                    //Platformları yazdır
                    for (Platform filmPlatform : film.getPlatformList()) {
                        System.out.print(filmPlatform.getPlatformName() + ", ");
                    }
                    // Gösterim saatlerini yazdır
                    System.out.print("\n");
                    System.out.print("Gösterim Saatleri: ");
                    for (ShowTime filmShowTime : film.getShowHours()) {
                        System.out.print(filmShowTime.getHour() + ", ");
                    }
                    System.out.print("\n");
                }
            }
        }
        System.out.print("\n");
    }
}
