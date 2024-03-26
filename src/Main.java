import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        boolean isRunning = true;
        User user = new User();

        while (isRunning) {
            System.out.println("1. Login Mahasiswa");
            System.out.println("2. Login Admin");
            System.out.println("3. Keluar");
            System.out.print("Masukkan Pilihan: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    user.menuUser();
                    break;
                case 2:
                    user.menuAdmin();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Kode tidak valid. Coba lagi.");
            }
        }
    }
}