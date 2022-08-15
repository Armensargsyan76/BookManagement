package books.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    private String title;
    private Author authorName;
    private double price;
    private int count;
    private String genre;
    private User userRegistered;

    public Book(String title, Author authorName, double price, String genre, User user) {
        this.title = title;
        this.authorName = authorName;
        this.price = price;
        this.genre = genre;
        userRegistered = user;
    }


}