import java.util.Scanner;

class Student {
    private String[][] bookList = {
            {"1", "101", "George Orwell", "Avatar", "Fiction", "10"},
            {"2", "102", "J.K. Rowling", "Naruto", "Fantasy", "20"},
            {"3", "103", "Stephen King", "Azab", "Horror", "5"},
            {"4", "104", "iyolll", "kost pengamen", "action", "100"},
            {"5", "105", "B.J. Habibie", "habibie ainun", "biografi", "1"},
            {"6", "106", "Gina s. noer", "Rudy: masa muda sang visisoner", "biografi", "3"},
            {"7", "107", "Najwa Shihab", "catatan Najwa", "slice life", "5"},
            {"8", "108", "baiyohh", "pemburu duda ", "action", "4"}
    };

    private String[][] borrowedBooks = new String[0][6];

    public void displayBooks() {
        System.out.println("No\tBook ID\tAuthor\t\t\t\tTitle\t\t\tCategory\tStock");
        for (String[] book : bookList) {
            System.out.println(book[0] + "\t" + book[1] + "\t\t" + book[2] + "\t\t" + book[3] + "\t\t\t" + book[4] + "\t\t" + book[5]);
        }
    }

    public void displayBorrowedBooks() {
        System.out.println("No\tBook ID\tAuthor\t\t\t\tTitle\t\t\tCategory\tStatus");
        for (String[] book : borrowedBooks) {
            System.out.println(book[0] + "\t" + book[1] + "\t\t" + book[2] + "\t\t" + book[3] + "\t\t\t" + book[4]+ "\t\t" + "Borrowed");
        }
    }

    public void logout() {
        System.out.println("keluar.");
    }

    public void borrowBook(String bookId) {
        for (String[] book : bookList) {
            if (bookId.equals(book[1])) {
                if (Integer.parseInt(book[5]) > 0) {
                    String[] newBook = new String[6];
                    System.arraycopy(book, 0, newBook, 0, 6);
                    newBook[5] = String.valueOf(Integer.parseInt(newBook[5]) - 1);
                    String[] newBorrowedBook = new String[6];
                    System.arraycopy(book, 0, newBorrowedBook, 0, 6);
                    borrowedBooks = append(borrowedBooks, newBorrowedBook);
                    System.out.println("Buku berhasil dipinjam.");
                    return;
                } else {
                    System.out.println("Buku tidak tersedia.");
                    return;
                }
            }
        }
        System.out.println("Buku tidak ditemukan.");
    }

    public String[][] append(String[][] array, String[] toAppend) {
        String[][] newArray = new String[array.length + 1][];
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[array.length] = toAppend;
        return newArray;
    }

    public void menuStudent() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n1. menampilkan buku");
            System.out.println("2. list peminjaman buku ");
            System.out.println("3. peminjaman buku");
            System.out.println("4. keluar");
            System.out.print("masukan pilihan mu (1-4): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayBooks();
                    break;
                case 2:
                    displayBorrowedBooks();
                    break;
                case 3:
                    System.out.print("Enter book ID: ");
                    scanner.nextLine();
                    borrowBook(scanner.nextLine());
                    break;
                case 4:
                    logout();
                    isRunning = false;
                    break;
                default:
                    System.out.println("pilihan salah, silahkan masukan pilihan mu.");
            }
        }
    }
}