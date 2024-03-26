import java.util.Scanner;

public class User {
    private String[][] bookList = {
            {"|| 1", "101", "sasa", "belzebub", "horor", "10"},
            {"|| 2", "102", "sarnia", "pandora", "sci-fi", "20"},
            {"|| 3", "103", "faldemir", "rune", "adventure", "14",},
            {"|| 4", "104", "nishinoya", "kaizen", "fantasy","8" },
            {"|| 5", "105", "kiryuu", "black.clover", "adventure", "13"}
    };

    private String[][] borrowedBooks = new String[0][6];

    private String[][] userStudent = {};

    private final String admin_username = "admin";
    private final String admin_password = "admin";

    public void displayBooks() {
        System.out.println("========================================================================");
        System.out.println("|| No\tBook ID\tPenulis\t\t\tJudul\t\t\tKategori\tStock     ||");
        System.out.println("========================================================================");
        for (String[] book : bookList) {
            System.out.println(book[0] + "\t" + book[1] + "\t\t" + book[2] + "\t\t" + book[3] + "\t\t\t" + book[4] + "\t\t" + book[5]);
        }
        System.out.println("========================================================================");
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
                    System.out.println("Buku berhasil dipinjam.\n");
                    return;
                } else {
                    System.out.println("Buku tidak tersedia.\n");
                    return;
                }
            }
        }
        System.out.println("Buku tidak ditemukan.\n");
    }

    public void displayBorrowedBooks() {
        System.out.println("No\tBook ID\tAuthor\t\t\t\tTitle\t\t\tCategory\tStatus");
        for (String[] book : borrowedBooks) {
            System.out.println(book[0] + "\t" + book[1] + "\t\t" + book[2] + "\t\t" + book[3] + "\t\t\t" + book[4] + "\t\tBorrowed");
        }
    }



    public void menuAdmin() {
        Scanner scanner = new Scanner(System.in);
        String Username, password;

        System.out.print("Masukkan username : ");
        Username = scanner.nextLine();
        System.out.print("Masukkan password : ");
        password = scanner.nextLine();

        if (!Username.equals(admin_username) || !password.equals(admin_password)) {
            System.out.println("Username atau password salah.\n");
            return;
        }

        int choice;
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n=== Admin Menu ===");
            System.out.println("1. Tambahkan Mahasiswa");
            System.out.println("2. Tampilkan Mahasiswa");
            System.out.println("3. Logout");
            System.out.print("Masukkan Pilihan: ");
            choice = scanner.nextInt();


            switch (choice) {
                case 1:

                    String Nim;
                    String nama;
                    String jurusan;
                    System.out.println("masukan NIM mahasiswa :");
                    scanner.nextLine();
                    Nim = scanner.nextLine();
                    System.out.print("Masukkan Nama Mahasiswa: ");
                    nama= scanner.nextLine();
                    System.out.print("Masukkan Jurusan Mahasiswa: ");
                    jurusan = scanner.nextLine();

                    String[] newStudent = {Nim, nama, jurusan};
                    addStudent(newStudent);
                    break;
                case 2:
                    displayStudent();
                    break;
                case 3:
                    System.out.println("Logout.\n");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Coba lagi.\n");
            }
        }
    }

    private void addStudent(String[] newStudent) {
        userStudent = append(userStudent, newStudent);
        System.out.println("Mahasiswa berhasil ditambahkan.");
    }


    private void displayStudent() {

        System.out.println("========================================================================");
        System.out.println("|| NIM\t\t\t\tNama\t\t\tJurusan");
        System.out.println("========================================================================");
        for (String[] student : userStudent) {
            System.out.println("|| " + student[0] + "\t" + student[1] + "\t\t" + student[2]);
        }
        System.out.println("========================================================================");
    }
    public void menuUser() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        boolean isRunning = true;
        String nim;
        System.out.print("Masukkan NIM: ");
        nim = scanner.nextLine();


        if (nim.length() != 15) {
            System.out.println("NIM tidak valid. Harus 15 digit!.\n");
            return;
        }

        while (isRunning) {
            System.out.println("\n=== User Menu ===");
            System.out.println("1. Pilihan Buku");
            System.out.println("2. Tampilkan Buku yang dipinjam");
            System.out.println("3. Pinjam Buku");
            System.out.println("4. Keluar");
            System.out.print("Masukkan Pilihan: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayBooks();
                    break;
                case 2:
                    displayBorrowedBooks();
                    break;
                case 3:
                    System.out.print("Masukkan book ID : ");
                    scanner.nextLine(); // Membersihkan pindah baris yang tersisa
                    borrowBook(scanner.nextLine());
                    break;
                case 4:

                case 5:
                    System.out.println("Logged out.\n");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Coba lagi.\n");
            }
        }
    }

    private String[][] append(String[][] array, String[] toAppend) {
        String[][] newArray = new String[array.length + 1][];
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[array.length] = toAppend;
        return newArray;
    }
}
