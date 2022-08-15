package books.storage;


import books.model.User;

public class UserStorage {

    private User[] array = new User[10];
    private int size;

    public void add(User user) {
        if (size == array.length) {
            extend();
        }
        array[size++] = user;
    }

    private void extend() {
        User[] tmp = new User[array.length * 2];
        for (int i = 0; i < array.length; i++) {
            tmp[i] = array[i];
        }
        array = tmp;
    }

    public void printAllUser() {
        for (int i = 0; i < size; i++) {
            System.out.println(i + " " + array[i]);
        }
    }

    public int getSize() {
        return size;
    }

    public User getUserByEmail(String userEmail) {
        for (int i = 0; i < size; i++) {
            if (array[i].getEmail().equals(userEmail)) {
                return array[i];
            }
        }
        return null;
    }
}
