import java.util.Scanner;

class Admin {
    private String[][] userStudent = {
    };

    public void addStudent() {
        Scanner scanner = new Scanner(System.in);
        String nim, name, faculty, programStudy;

        System.out.print("Enter NIM: ");
        nim = scanner.nextLine();

        if (nim.length() != 15) {
            System.out.println("nim salah, harus 15 karakter.");
            return;
        }

        System.out.print("masukan nama: ");
        name = scanner.nextLine();

        System.out.print("masukan fakultas: ");
        faculty = scanner.nextLine();

        System.out.print("masukan jurusan: ");
        programStudy = scanner.nextLine();

        userStudent = addToArray(userStudent, nim, name, faculty, programStudy);
    }

    public String[][] displayStudent() {
        System.out.println("NIM\t\t\t\tName\tFaculty\t\tProgram Study");
        for (String[] student: userStudent) {
            System.out.println(student[0] + "\t" + student[1] + "\t" + student[2] + "\t\t\t" + student[3]);
        }
        return userStudent;
    }

    public String[][] addToArray(String[][] array, String nim, String name, String faculty, String programStudy) {
        String[][] newArray = new String[array.length + 1][];

        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }

        newArray[array.length] = new String[]{nim, name, faculty, programStudy};

        return newArray;
    }

    public void menuAdmin() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n1. tambahkan mahasiswa");
            System.out.println("2. tampilan mahasiswa ");
            System.out.println("3. keluar");
            System.out.print("masukan pilihan mu ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayStudent();
                    break;
                case 3:
                    System.out.println("keluar.");
                    isRunning = false;
                    break;
                default:
                    System.out.println("pilihan salah, silahkan masukan.");
            }
        }
    }
}