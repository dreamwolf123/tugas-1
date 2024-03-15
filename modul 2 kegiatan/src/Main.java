import java.util.ArrayList;
import java.util.Scanner;

class Book {
    String id, title, author, category;
    int availableCopies;

    public Book(String id, String title, String author, String category, int availableCopies) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;
        this.availableCopies = availableCopies;
    }
}

class Student {
    String name, faculty, nim, program;

    public Student(String name, String faculty, String nim, String program) {
        this.name = name;
        this.faculty = faculty;
        this.nim = nim;
        this.program = program;
    }
}

public class Main {
    private static ArrayList<Book> books = new ArrayList<>();
    private static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        books.add(new Book("1", "buku 1", "authorSejarah", "Sejarah", 4));
        books.add(new Book("2", "buku 2", "authorAdventure", "adventure", 3));
        books.add(new Book("3", "buku 3", "authorComedy", "comedy", 2));
        books.add(new Book("4", "buku 4", "authorRomance1", "romance", 5));


        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("==== Library System =====");
            System.out.println("1. Login as Student");
            System.out.println("2. Login as Admin");
            System.out.println("3. Exit");
            System.out.print("Choose option (1-3): ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                loginAsStudent(scanner);
            } else if (choice == 2) {
                loginAsAdmin(scanner);
            } else if (choice == 3) {
                System.out.println("Goodbye!");
                break;
            }else {
                System.out.println("Invalid option, please choose again.");
            }
        }

        scanner.close();
    }

    private static void loginAsStudent(Scanner scanner) {
        System.out.print("Enter your name: ");
        String name = scanner.next();

        System.out.print("Enter your faculty: ");
        String faculty = scanner.next();

        System.out.print("Enter your NIM: ");
        String nim = scanner.next();

        System.out.print("Enter your program: ");
        String program = scanner.next();

        Student student = new Student(name, faculty, nim, program);
        students.add(student);

        System.out.println("Welcome, " + name + "!");

        while (true) {
            System.out.println("\n==== Student Menu =====");
            System.out.println("1. Pinjam Buku");
            System.out.println("2. Kembalikan Buku");
            System.out.println("3. Logout");
            System.out.print("Choose option (1-3): ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                borrowBook(scanner);
            } else if (choice == 2) {
                returnBook(scanner);
            } else if (choice == 3) {
                System.out.println("Goodbye, " + name + "!");
                break;
            } else {
                System.out.println("Invalid option, please choose again.");
            }
        }
    }

    private static void loginAsAdmin(Scanner scanner) {
        String username = "admin";
        String password = "password";
        String inputUsername, inputPassword;

        System.out.println("\n==== Admin Login =====");
        System.out.print("Enter username: ");
        inputUsername = scanner.next();

        System.out.print("Enter password: ");
        inputPassword = scanner.next();

        if (username.equals(inputUsername) && password.equals(inputPassword)) {System.out.println("Welcome, Admin!");

            while (true) {
                System.out.println("\n==== Admin Menu =====");
                System.out.println("1. Add Book");
                System.out.println("2. Display Books");
                System.out.println("3. Add Student");
                System.out.println("4. Display Registered Students");
                System.out.println("5. Logout");
                System.out.print("Choose option (1-5): ");
                int choice = scanner.nextInt();

                if (choice == 1) {
                    addBook(scanner);
                } else if (choice == 2) {
                    displayBooks();
                } else if (choice == 3) {
                    addStudent(scanner);
                } else if (choice == 4) {
                    displayRegisteredStudents();
                } else if (choice == 5) {
                    System.out.println("Goodbye, Admin!");
                    break;
                } else {
                    System.out.println("Invalid option, please choose again.");
                }
            }
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    private static void addBook(Scanner scanner) {
        System.out.print("Enter book ID: ");
        String id = scanner.next();

        System.out.print("Enter book title: ");
        String title = scanner.next();

        System.out.print("Enter book author: ");
        String author = scanner.next();

        System.out.print("Enter book category: ");
        String category = scanner.next();

        System.out.print("Enter available copies: ");
        int availableCopies = scanner.nextInt();

        books.add(new Book(id, title, author, category, availableCopies));

        System.out.println("Book added successfully.");
    }

    private static void displayBooks() {
        System.out.println("\n==== Books =====");

        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            System.out.println((i + 1) + ". " + book.title + " by " + book.author);
        }
    }

    private static void addStudent(Scanner scanner) {
        System.out.print("Enter student name: ");
        String name = scanner.next();

        System.out.print("Enter student faculty: ");
        String faculty = scanner.next();

        System.out.print("Enter student NIM: ");
        String nim = scanner.next();

        System.out.print("Enter student program: ");
        String program = scanner.next();

        students.add(new Student(name, faculty, nim, program));

        System.out.println("Student added successfully.");
    }

    private static void displayRegisteredStudents() {
        System.out.println("\n==== Registered Students =====");

        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            System.out.println((i + 1) + ". " + student.name + " (NIM: " + student.nim + ")");
        }
    }

    private static void borrowBook(Scanner scanner) {
        System.out.println("\n==== Pinjam Buku =====");
        System.out.println("Available Books:");

        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if (book.availableCopies > 0) {
                System.out.println((i + 1) + ". " + book.title + " by " + book.author);
            }
        }

        System.out.print("Pilih Buku untuk di Pinjam (1-" + books.size() + "): ");
        int choice = scanner.nextInt();

        if (choice >= 1 && choice <= books.size()) {
            Book book = books.get(choice - 1);
            if (book.availableCopies> 0) {
                book.availableCopies--;
                System.out.println("You have successfully borrowed " + book.title + " by " + book.author + ".");
            } else {
                System.out.println("Sorry, this book is currently unavailable.");
            }
        } else {
            System.out.println("Invalid option, please choose again.");
        }
    }

    private static void returnBook(Scanner scanner) {
        System.out.println("\n==== Kembalikan Buku =====");
        System.out.println("Available Books:");

        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            System.out.println((i + 1) + ". " + book.title + " by " + book.author);
        }

        System.out.print("Choose book to return (1-" + books.size() + "): ");
        int choice = scanner.nextInt();

        if (choice >= 1 && choice <= books.size()) {
            Book book = books.get(choice - 1);
            book.availableCopies++;
            System.out.println("You have successfully returned " + book.title + " by " + book.author + ".");
        } else {
            System.out.println("Invalid option, please choose again.");
        }
    }
}