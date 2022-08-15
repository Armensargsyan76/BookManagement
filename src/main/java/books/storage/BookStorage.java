package books.storage;

import books.model.Author;
import books.model.Book;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class BookStorage {

    private Book[] array = new Book[10];
    private int size;

    public void add(Book book) {
        if (size == array.length) {
            extend();
        }
        array[size++] = book;
    }

    private void extend() {
        Book[] tmp = new Book[array.length * 2];
        for (int i = 0; i < array.length; i++) {
            tmp[i] = array[i];
        }
        array = tmp;
    }

    public void printAllBooks() {
        for (int i = 0; i < size; i++) {
            System.out.println(i + " " + array[i]);
        }
    }

    public void getAuthorNameBooks(Author authorName) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (array[i].getAuthorName().equals(authorName)) {
                System.out.println(array[i]);
                count++;
            }
        }
        if (count == 0) {
            System.out.println("There are no books by the author");
        }

    }

    public void printBookByGenre(String genre) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (array[i].getGenre().equals(genre)) {
                System.out.println(array[i]);
                count++;
            }
        }
        if (count == 0) {
            System.out.println("There are no books by this genre");
        }
    }

    public void printBooksByPriceRange(int rangeFrom, int rangeTo) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (array[i].getPrice() >= rangeFrom && array[i].getPrice() <= rangeTo) {
                System.out.println(array[i]);
                count++;
            }
        }
        if (count == 0) {
            System.out.println("There are no books in this price range");
        }
    }


    public void writeBooksExcel(String fileDir) throws IOException {
        File directory = new File(fileDir);
        if (directory.isFile()) {
            throw new RuntimeException("fileDir must be a directory");
        }
        File excelFile = new File(directory, "books_" + System.currentTimeMillis() + ".xlsx");
        excelFile.createNewFile();
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("books");
        Row headerRow = sheet.createRow(0);

        Cell titleCell = headerRow.createCell(0);
        titleCell.setCellValue("title");


        Cell priceCell = headerRow.createCell(1);
        priceCell.setCellValue("price");

        Cell genreCell = headerRow.createCell(3);
        genreCell.setCellValue("genre");

        for (int i = 0; i < size; i++) {
            Book book = array[i];
            Row row = sheet.createRow(i + 1);
            row.createCell(0).setCellValue(book.getTitle());
            row.createCell(2).setCellValue(book.getPrice());
            row.createCell(3).setCellValue(book.getGenre());
        }
        workbook.write(new FileOutputStream(excelFile));
        System.out.println("excel was created successfully");

    }

}
