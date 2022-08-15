package books.command;

public interface Commands {

    int EXIT = 0;
    int ADD_BOOK = 1;
    int PRINT_ALL_BOOKS = 2;
    int PRINT_BOOKS_BY_AUTHOR_NAME = 3;
    int PRINT_BOOKS_BY_GENRE = 4;
    int PRINT_BOOKS_BY_PRICE_RANGE = 5;
    int ADD_AUTHORS = 6;
    int PRINT_AUTHORS = 7;
    int LOGOUT = 0;
    int LOGIN = 1;
    int REGISTER = 2;

    int DOWNLOAD_BOOKS_EXCEL = 9;


    static void printAdminCommands() {
        System.out.println("Please input " + LOGOUT + " for logout");
        System.out.println("Please input " + ADD_BOOK + " for add book's");
        System.out.println("Please input " + PRINT_ALL_BOOKS + " for print all book's");
        System.out.println("Please input " + PRINT_BOOKS_BY_AUTHOR_NAME + " for print book's by author name");
        System.out.println("Please input " + PRINT_BOOKS_BY_GENRE + " for print book's by genre");
        System.out.println("Please input " + PRINT_BOOKS_BY_PRICE_RANGE + " for print book's by price range");
        System.out.println("Please input " + ADD_AUTHORS + " for add author's");
        System.out.println("Please input " + PRINT_AUTHORS + " for print all author's");
        System.out.println("Please input " + DOWNLOAD_BOOKS_EXCEL + " for download books excel");
    }


    static void printLoginCommands() {
        System.out.println("Please input " + EXIT + " for exit");
        System.out.println("Please input " + LOGIN + " for login");
        System.out.println("Please input " + REGISTER + " for register");
    }

    static void printUserCommands() {
        System.out.println("Please input " + LOGOUT + " for logout");
        System.out.println("Please input " + ADD_BOOK + " for add book's");
        System.out.println("Please input " + PRINT_ALL_BOOKS + " for print all book's");
        System.out.println("Please input " + PRINT_BOOKS_BY_AUTHOR_NAME + " for print book's by author name");
        System.out.println("Please input " + PRINT_BOOKS_BY_GENRE + " for print book's by genre");
        System.out.println("Please input " + PRINT_BOOKS_BY_PRICE_RANGE + " for print book's by price range");
        System.out.println("Please input " + ADD_AUTHORS + " for add author's");
        System.out.println("Please input " + PRINT_AUTHORS + " for print all author's");
        System.out.println("Please input " + DOWNLOAD_BOOKS_EXCEL + " for download books excel");
    }


}