package books.storage;

import books.exception.AuthorNotFoundException;
import books.model.Author;
import books.exception.AuthorNotFoundException;
import books.model.Author;

public class AuthorStorage {

    private Author[] array = new Author[10];
    private int size;

    public void add(Author author) {
        if (size == array.length) {
            extend();
        }
        array[size++] = author;
    }

    private void extend() {
        Author[] tmp = new Author[array.length * 2];
        for (int i = 0; i < array.length; i++) {
            tmp[i] = array[i];
        }
        array = tmp;
    }

    public void printAllAuthor() {
        for (int i = 0; i < size; i++) {
            System.out.println(i + " " + array[i]);
        }
    }

    public int getSize() {
        return size;
    }

    public Author getAuthorByIndex(int authorIndex) throws AuthorNotFoundException {
        if (authorIndex < 0 || authorIndex >= size) {
            throw new AuthorNotFoundException("Please choose correct index");
        } else {
            return array[authorIndex];
        }

    }
}
