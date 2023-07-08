package models;

import java.util.List;

public class Category {
    private String categoryName;

    private int filmCount;

    public Category(String categoryName) {
        this.categoryName = categoryName;
        this.filmCount = 0;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getFilmCount() {
        return filmCount;
    }

    public void setFilmCount(int filmCount) {
        this.filmCount = filmCount;
    }



    @Override
    public String toString() {
        return "Category{" +
                "categoryName='" + categoryName + '\'' +
                ", filmCount=" + filmCount +
                '}';
    }

}
