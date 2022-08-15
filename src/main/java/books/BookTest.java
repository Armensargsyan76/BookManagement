package books;

import books.command.Commands;
import books.enumstorage.Gender;
import books.enumstorage.UserType;
import books.exception.AuthorNotFoundException;
import books.model.Author;
import books.model.Book;
import books.model.User;
import books.storage.AuthorStorage;
import books.storage.BookStorage;
import books.storage.UserStorage;
import books.command.Commands;
import books.enumstorage.Gender;
import books.enumstorage.UserType;
import books.exception.AuthorNotFoundException;
import books.model.Author;
import books.model.Book;
import books.model.User;
import books.storage.AuthorStorage;
import books.storage.BookStorage;
import books.storage.UserStorage;

import java.io.IOException;
import java.util.Scanner;

public class BookTest implements Commands {

    private static Scanner scanner = new Scanner(System.in);
    public static BookStorage bookStorage = new BookStorage();
    public static AuthorStorage authorStorage = new AuthorStorage();

    public static UserStorage userStorage = new UserStorage();

    private static User currentUser = null;

    public static void main(String[] args) {
        initData();
        runProgram();
    }

    private static void runProgram() {
        boolean run = true;
        while (run) {
            Commands.printLoginCommands();
            int command;
            try {
                command = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                command = -1;
            }
            switch (command) {
                case EXIT:
                    run = false;
                    break;
                case LOGIN:
                    login();
                    break;
                case REGISTER:
                    registerUser();
            }
        }
    }

    private static void initData() {
        User admin = new User("admin", "adminyan", "admin@.com", "admin", UserType.ADMIN);
        userStorage.add(admin);
        Author JKRowling = new Author("Joanne", "Rowling", "@harryPotter.com", Gender.FEMALE);
        Author MarioPuzo = new Author("Mario", "Puzo", "@maildraxt.com", Gender.MALE);
        Author ArthurConanDoyle = new Author("Arthur", "Conan_Doyle", "@mailSherlock.com", Gender.MALE);
        Author JohnTolkien = new Author("John", "Tolkien", "@mailGendalf.com", Gender.MALE);
        authorStorage.add(JKRowling);
        authorStorage.add(MarioPuzo);
        authorStorage.add(ArthurConanDoyle);
        authorStorage.add(JohnTolkien);
        bookStorage.add(new Book("GodFather", MarioPuzo, 50000, "criminal drama", admin));
        bookStorage.add(new Book("Sherlock Holmes", ArthurConanDoyle, 40000, "detective", admin));
        bookStorage.add(new Book("Hobbit", JohnTolkien, 30000, "fantasy", admin));
        bookStorage.add(new Book("Harry Potter", JKRowling, 25000, "fantasy", admin));
    }

    private static void logAdmin() {
        boolean run = true;
        while (run) {
            Commands.printAdminCommands();
            ;
            int command;
            try {
                command = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                command = -1;
            }
            switch (command) {
                case EXIT:
                    run = false;
                    break;
                case ADD_BOOK:
                    addBook();
                    break;
                case PRINT_ALL_BOOKS:
                    bookStorage.printAllBooks();
                    break;
                case PRINT_BOOKS_BY_AUTHOR_NAME:
                    printBooksByAuthorName();
                    break;
                case PRINT_BOOKS_BY_GENRE:
                    printBooksByGenre();
                    break;
                case PRINT_BOOKS_BY_PRICE_RANGE:
                    printBooksByRange();
                    break;
                case ADD_AUTHORS:
                    addAuthor();
                    break;
                case PRINT_AUTHORS:
                    authorStorage.printAllAuthor();
                    break;
                case DOWNLOAD_BOOKS_EXCEL:
                    downloadBooksExcel();
                    break;
                default:
                    System.out.println("invalid command");
            }


        }
    }

    private static void logUser() {
        boolean run = true;
        while (run) {
            Commands.printUserCommands();

            int command;
            try {
                command = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                command = -1;
            }
            switch (command) {
                case EXIT:
                    run = false;
                    break;
                case ADD_BOOK:
                    addBook();
                    break;
                case PRINT_ALL_BOOKS:
                    bookStorage.printAllBooks();
                    break;
                case PRINT_BOOKS_BY_AUTHOR_NAME:
                    printBooksByAuthorName();
                    break;
                case PRINT_BOOKS_BY_GENRE:
                    printBooksByGenre();
                    break;
                case PRINT_BOOKS_BY_PRICE_RANGE:
                    printBooksByRange();
                    break;
                case ADD_AUTHORS:
                    addAuthor();
                    break;
                case PRINT_AUTHORS:
                    authorStorage.printAllAuthor();
                    break;
                case DOWNLOAD_BOOKS_EXCEL:
                    downloadBooksExcel();
                    break;
                default:
                    System.out.println("invalid command");
            }
        }
    }

    private static void downloadBooksExcel() {
        System.out.println("please input file location");
        String fileDir = scanner.nextLine();
        try {
            bookStorage.writeBooksExcel(fileDir);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Gender chooseGenderByIndex() {
        Gender[] genders = Gender.values();
        System.out.println("Please choose correct author gender index");
        for (Gender genderValue : genders) {
            System.out.println(genderValue.ordinal() + ": " + genderValue);
        }
        int genderIndex;
        Gender gender = null;
        try {
            genderIndex = Integer.parseInt(scanner.nextLine());
            gender = genders[genderIndex];
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println("please input correct index");
            addAuthor();

        }
        return gender;
    }


    private static void addAuthor() {
        System.out.println("Please input author name");
        String authorName = scanner.nextLine();
        System.out.println("Please input author surname");
        String authorSurName = scanner.nextLine();
        System.out.println("Please input author email");
        String email = scanner.nextLine();
        Gender gender = chooseGenderByIndex();
        if (gender == null) {
        } else {
            if (authorName == null || authorName.equals("")) {
                System.out.println("Please input author name!!!");
            } else if (authorSurName == null || authorSurName.equals("")) {
                System.out.println("Please input author surname");
            } else if (!email.contains("@")) {
                System.out.println("please input correct email");
            } else {
                Author author = new Author(authorName.trim(), authorSurName.trim(), email.trim(), gender);
                authorStorage.add(author);
                System.out.println("author created");
            }
        }

    }


    private static void printBooksByRange() {
        int rangeFrom = 0;
        int rangeTo = 0;
        try {
            System.out.println("Please input range from");
            rangeFrom = Integer.parseInt(scanner.nextLine());
            System.out.println("Please input price to");
            rangeTo = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("please note only numbers");
        }

        int tmp = 0;
        if (rangeFrom > rangeTo) {
            tmp = rangeTo;
            rangeTo = rangeFrom;
            rangeFrom = tmp;
        }
        bookStorage.printBooksByPriceRange(rangeFrom, rangeTo);
    }

    private static void printBooksByGenre() {
        System.out.println("Please input genre");
        String genre = scanner.nextLine();
        bookStorage.printBookByGenre(genre);
    }

    private static void printBooksByAuthorName() {
        if (authorStorage.getSize() != 0) {
            authorStorage.printAllAuthor();
            System.out.println("Please choose author index");
            try {
                int index = Integer.parseInt(scanner.nextLine());
                Author author = authorStorage.getAuthorByIndex(index);
                if (author != null) {
                    bookStorage.getAuthorNameBooks(author);
                } else {
                    System.out.println("Please choose correct index");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please note only numbers");
            } catch (AuthorNotFoundException e) {
                System.out.println(e);
            }
        } else {
            System.out.println("Please create author");
        }

    }


    private static void addBook() {
        if (authorStorage.getSize() == 0) {
            System.out.println("for create book need has author");
            System.out.println(" please create author");
            System.out.println("for create author choose_1: for exit choose_2");
            int command = 0;
            try {
                command = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("please input only numbers");
            }

            if (command == 1) {
                addAuthor();
            } else if (false) ;
        } else {
            authorStorage.printAllAuthor();
            System.out.println("please choose index author");
            Author author = null;
            try {
                int authorIndex = Integer.parseInt(scanner.nextLine());
                author = authorStorage.getAuthorByIndex(authorIndex);
            } catch (AuthorNotFoundException e) {
                System.out.println(e);
            } catch (NumberFormatException e) {
                System.out.println("please input only numbers");
            }
            if (author == null) {
                System.out.println("please choose correct index!!!");
                addBook();
            } else {
                System.out.println("Please input book's name");
                String booksName = scanner.nextLine();
                System.out.println("Please input genre");
                String genre = scanner.nextLine();
                try {
                    System.out.println("Please input price");
                    double price = Double.parseDouble(scanner.nextLine());
                    if (booksName == null || booksName.equals("")) {
                        System.out.println("Please input book's name!!!!");
                    } else if (price < 0) {
                        System.out.println("Please input correct price");
                    } else if (genre == null || genre.equals("")) {
                        System.out.println("Please input genre name!!!!");
                    } else {
                        Book book = new Book(booksName.trim(), author, price, genre.trim(), currentUser);
                        bookStorage.add(book);
                        System.out.println("book created");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Please note only numbers");
                    addBook();
                }
            }
        }

    }


    private static void registerUser() {
        System.out.println("please input name, surName, email, password");
        String userStr = scanner.nextLine();
        String[] data = userStr.split(",");
        if (data.length < 4) {
            System.out.println("please input correct data");
        } else {
            if (data[0].equals("")) {
                System.out.println("please input name!!!");
            } else if (data[1].equals("")) {
                System.out.println("please input sur name!!!");
            } else if (userStorage.getUserByEmail(data[2]) == null && data[2].contains("@")) {
                User user = new User();
                user.setName(data[0]);
                user.setSurname(data[1]);
                user.setEmail(data[2]);
                user.setPassword(data[3]);
                user.setUsertype(UserType.USER);
                userStorage.add(user);
                System.out.println("user created");
            } else {
                System.out.println("please input correct email");
            }

        }
    }

    private static void login() {
        System.out.println("please input email,password");
        String emailPasswordStr = scanner.nextLine();
        String[] emailPassword = emailPasswordStr.split(",");
        if (emailPassword.length < 2) {
            System.out.println("please input correct data");
        }else {
            User user = userStorage.getUserByEmail(emailPassword[0]);
            if (user == null) {
                System.out.println("email witch " + emailPassword[0] + " does not exists");
            } else if (user.getPassword().equals(emailPassword[1])) {
                currentUser = user;
                if (user.getUsertype() == UserType.ADMIN) {
                    logAdmin();
                } else if (user.getUsertype() == UserType.USER) {
                    logUser();
                }
            } else {
                System.out.println("wrong password!");
            }

        }

    }

}




