package service;

import model.Category;
import model.Film;

import java.util.List;

public class CategoryService {

    public boolean findCategory(List<Category> categoryList, String categoryName) {
        for (Category category : categoryList) {
            if (category.getCategoryName().equals(categoryName)) {
                return true;
            }
        }
        return false;
    }

    public Category returnCategory(List<Category> categoryList, String categoryName) {
        for (Category category : categoryList) {
            if (category.getCategoryName().equals(categoryName)) {
                return category;
            }
        }
        return null;
    }

    public void updateCategoryFilmCount(List<Film> filmList, List<Category> categoryList) {
        for (Category category : categoryList) {
            int filmCount = 0;
            for (Film film : filmList) {
                for (Category filmCategory : film.getCategoryList()) {
                    if (filmCategory.getCategoryName().equals(category.getCategoryName())) {
                        filmCount++;
                    }
                }
            }
            category.setFilmCount(filmCount);
        }
    }
}
