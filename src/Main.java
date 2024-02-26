import java.util.Scanner;

class Main {
    private static String[] students = { "202310370311111", "123456" };
    private static String adminNIM = "admin";
    private static String adminPassword = "admIn";
    private static int studentIndex = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Library System");
            System.out.println("1. Login as Student");
            System.out.println("2. Login as Admin");
            System.out.println("3. Exit");
            System.out.print("Choose option (1-3): ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("Enter your NIM : ");
                String nim = scanner.next();
                if (loginStudent(nim)) {
                    System.out.println("Berhasil login Mahasiswa");
                } else {
                    System.out.println("User tidak ditemukan");
                }
            } else if (choice == 2) {
                System.out.print("Enter your username: ");
                String username = scanner.next();
                System.out.print("Enter your password: ");
                String password = scanner.next();
                if (loginAdmin(username, password)) {
                    System.out.println("Berhasil login Admin");
                } else {
                    System.out.println("Admin User tidak ditemukan");
                }
            } else if (choice == 3) {
                System.out.println("adios - (arisu GLM4deu) - [ ~ ] - ");
                break;
            }
        }
    }

    private static boolean loginStudent(String nim) {
        for (int i = 0; i < students.length; i++) {
            if (students[i].equals(nim)) {
                studentIndex = i;
                return true;
            }
        }
        return false;
    }

    private static boolean loginAdmin(String username, String password) {
        return adminNIM.equals(username) && adminPassword.equals(password);
    }
}