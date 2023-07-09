package model;

import java.util.List;

public class Film {
    private List<Category> categoryList;
    private List<Platform> platformList;
    private String filmName;
    private String directorName;
    private int publishYear;
    private List<ShowTime> showHours;

    public Film(List<Category> categoryList, List<Platform> platformList, String filmName, String directorName, int publishYear, List<ShowTime> showHours) {
        this.categoryList = categoryList;
        this.platformList = platformList;
        this.filmName = filmName;
        this.directorName = directorName;
        this.publishYear = publishYear;
        this.showHours = showHours;
    }

    @Override
    public String toString() {
        return "Film{" +
                "categoryList=" + categoryList +
                ", platformList=" + platformList +
                ", filmName='" + filmName + '\'' +
                ", directorName='" + directorName + '\'' +
                ", publishYear=" + publishYear +
                ", showHours=" + showHours +
                '}';
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public List<Platform> getPlatformList() {
        return platformList;
    }

    public void setPlatformList(List<Platform> platformList) {
        this.platformList = platformList;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public List<ShowTime> getShowHours() {
        return showHours;
    }

    public void setShowHours(List<ShowTime> showHours) {
        this.showHours = showHours;
    }
}
