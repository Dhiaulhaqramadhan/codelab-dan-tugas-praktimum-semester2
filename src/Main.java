import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        boolean isRunning = true;
        Admin admin = new Admin();
        Student student = new Student();

        while (isRunning) {
            System.out.println("1. Login sebagai admin");
            System.out.println("2. Login sebagai mahasiswa");
            System.out.println("3. keluar");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    admin.menuAdmin();
                    break;
                case 2:
                    student.menuStudent();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    isRunning = false;
                    break;
                default:
                    System.out.println("piliahn salah, silhkan coba lagi.");
            }
        }
    }
}