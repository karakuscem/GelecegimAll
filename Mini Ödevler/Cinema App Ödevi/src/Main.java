import models.Category;
import models.Film;
import models.Platform;
import models.ShowTime;
import service.FilmService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Film> filmList = new ArrayList<>(); // Filmlerin hepsinin tutulduğu liste
        List<Category> categoryList = new ArrayList<>(); // Filmleri eklerken yaratılan kategoriler
        FilmService filmService = new FilmService(); // Film Servisleri için oluşturulan nesne
        Scanner input = new Scanner(System.in); // Input için gerekli

        while (true) { // Programın ana döngüsü
            System.out.println("Kullanıcı seçin.\nAdmin için: 1\nKullanıcı için: 2\nÇıkış için: 3");
            int inputNum = input.nextInt();

            if (inputNum == 1) {
                List<Category> filmCategoryList = new ArrayList<>(); // Eklenecek film için kategori listesi
                List<Platform> filmPlatformList = new ArrayList<>(); // Eklenecek film için platform listesi
                List<ShowTime> filmShowTimeList = new ArrayList<>(); // Eklenecek film için gösterim saatleri listesi

                while (true) { // Kategori ekleme döngüsü
                    System.out.println("Kategori ismi girin.");
                    String categoryName = input.next();

                    if (filmService.findCategory(categoryList, categoryName)) { // Eğer kategori zaten varsa
                        Category category = filmService.returnCategory(categoryList, categoryName); // Kategoriyi genel listeden bul

                        if (!filmCategoryList.contains(category)) { // Eğer filmin kategori listesine daha önce eklenmemişse ekle
                            filmCategoryList.add(category);
                        }
                    } else { // Eğer kategori yoksa
                        Category category = new Category(categoryName); // Kategori yarat
                        categoryList.add(category); // Genel kategori listesine ekle
                        filmCategoryList.add(category); // Filmin kategori listesine ekle
                    }

                    System.out.println("Başka kategori eklemek istiyor musunuz? (E/H)");
                    String answer = input.next();

                    if (answer.equalsIgnoreCase("H")) {
                        break;
                    } else if (!answer.equalsIgnoreCase("E")) {
                        System.out.println("Hatalı giriş yaptınız.");
                        break;
                    }
                }

                while (true) { // Platform ekleme döngüsü
                    System.out.println("Platform ismi girin.");
                    String platformName = input.next();
                    Platform platform = new Platform(platformName);
                    filmPlatformList.add(platform);

                    System.out.println("Başka platform eklemek istiyor musunuz? (E/H)");
                    String answer = input.next();

                    if (answer.equalsIgnoreCase("H")) {
                        break;
                    } else if (!answer.equalsIgnoreCase("E")) {
                        System.out.println("Hatalı giriş yaptınız.");
                        break;
                    }
                }
                // Filmin geri kalan bilgilerini al
                System.out.println("Film ismi girin.");
                String filmName = input.next();
                System.out.println("Yönetmen ismi girin.");
                String directorName = input.next();
                System.out.println("Yapım yılı girin.");
                int year = input.nextInt();
                System.out.println("Gösterim tarihi girin.");
                String showTime = input.next();
                ShowTime showHours = new ShowTime(showTime);
                filmShowTimeList.add(showHours);
                // Yeni filmi yarat ve listeye ekle
                Film film = new Film(filmCategoryList, filmPlatformList, filmName, directorName, year, filmShowTimeList);
                filmService.addFilm(filmList, film);
                // Kategori sayılarını güncelle
                filmService.updateCategoryFilmCount(filmList, filmCategoryList);
            } else if (inputNum == 2) { // Kullanıcı için işlemler
                // Kategorilerin listesini sayılarıyla birlikte göster
                System.out.println("Görüntülemek istediğiniz kategoriyi girin.");
                for (int i = 0; i < categoryList.size(); i++) {
                    System.out.println((i + 1) + ". " + categoryList.get(i).getCategoryName());
                }
                // Seçilen kategorinin bilgisini al
                int categoryNum = input.nextInt();
                Category category = categoryList.get(categoryNum - 1);
                //Kategori bilgisini yazdır
                System.out.println(category.getCategoryName() + " kategorisinde" + category.getFilmCount() + " film bulunmaktadır.");
                // Film listesinde bulunan tüm filmleri dolaş
                for (Film film : filmList) {
                    // Film kategorilerini dolaş
                    for (Category filmCategory : film.getCategoryList()) {
                        // Eğer film kategorisi seçilen kategoriyle aynıysa
                        if (filmCategory.getCategoryName().equals(category.getCategoryName())) {
                            // Film bilgilerini yazdır
                            System.out.println("Film İsmi: " + film.getFilmName());
                            System.out.println("Yönetmen İsmi: " + film.getDirectorName());
                            System.out.println("Yapım Yılı: " + film.getPublishYear());
                            System.out.print("Kategoriler: ");
                            // Film kategorilerini yazdır döngü ile
                            for (Category filmCategory1 : film.getCategoryList()) {
                                System.out.print(filmCategory1.getCategoryName() + " ");
                            }
                            System.out.print("\n");
                            System.out.print("Platformlar: ");
                            //Platformları yazdır
                            for (Platform filmPlatform : film.getPlatformList()) {
                                System.out.print(filmPlatform.getPlatformName() + " ");
                            }
                            // Gösterim saatlerini yazdır
                            System.out.print("\n");
                            System.out.print("Gösterim Saatleri: ");
                            for (ShowTime filmShowTime : film.getShowHours()) {
                                System.out.print(filmShowTime.getHour());
                            }
                            System.out.print("\n");
                        }
                    }
                }
            } else if (inputNum == 3) { // Çıkış
                break;
            }
        }
    }
}
