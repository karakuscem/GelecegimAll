import java.util.Comparator;

public class Book implements Comparable<Book> {
    private String name;
    private int pageNum;
    private String author;
    private String date;

    public Book(String name, int pageNum, String author, String date) {
        this.name = name;
        this.pageNum = pageNum;
        this.author = author;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public int compareTo(Book o) {
        return this.name.compareTo(o.name);
    }

}
