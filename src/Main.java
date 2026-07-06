import java.util.Scanner;

public class Main {
    static final int MAX_STUDENTS = 10;
    static int[] ids = new int[MAX_STUDENTS];
    static String[] names = new String[MAX_STUDENTS];
    static int[] ages = new int[MAX_STUDENTS];
    static String[] courses = new String[MAX_STUDENTS];
    static double[] grades = new double[MAX_STUDENTS];
    static boolean[] enrolled = new boolean[MAX_STUDENTS];
    static int count = 0;

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = 0;

        while (choice != 5) {
            System.out.println("===== STUDENT INFORMATION SYSTEM =====");
            System.out.println("[1] Add Student");
            System.out.println("[2] View All Students");
            System.out.println("[3] Search Student by ID");
            System.out.println("[4] View Statistics");
            System.out.println("[5] Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewAllStudents();
                    break;
                case 3:
                    searchStudentById();
                    break;
                case 4:
                    viewStatistics();
                    break;
                case 5:
                    System.out.println("Thank you for using the Student Information System. Goodbye!");
                    break;
                default:
                    System.out.println(">> Invalid choice. Please select 1-5.");
            }
            System.out.println();
        }
    }

    static void addStudent() {
        if (count >= MAX_STUDENTS) {
            System.out.println(">> Cannot add student. The list is full.");
            return;
        }

        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Full Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Age: ");
        int age = scanner.nextInt();

        System.out.print("Enter Course: ");
        scanner.nextLine();
        String course = scanner.nextLine();

        System.out.print("Enter Grade: ");
        double grade = scanner.nextDouble();

        System.out.print("Is Enrolled (true/false): ");
        boolean isEnrolled = scanner.nextBoolean();
        scanner.nextLine();

        if (age <= 0) {
            System.out.println(">> Invalid age. Age must be positive.");
            return;
        }
        if (grade < 0 || grade > 100) {
            System.out.println(">> Invalid grade. Grade must be between 0 and 100.");
            return;
        }

        ids[count] = id;
        names[count] = name;
        ages[count] = age;
        courses[count] = course;
        grades[count] = grade;
        enrolled[count] = isEnrolled;
        count++;

        System.out.println(">> Student added successfully!");
    }

    static void viewAllStudents() {
        System.out.println("--- STUDENT RECORDS ---");

        if (count == 0) {
            System.out.println("No student records found.");
            return;
        }

        System.out.printf("%-6s%-15s%-6s%-9s%-8s%-15s%n",
                "ID", "NAME", "AGE", "COURSE", "GRADE", "STANDING");

        for (int i = 0; i < count; i++) {
            String standing;
            if (grades[i] >= 90) {
                standing = "Dean's Lister";
            } else if (grades[i] >= 75) {
                standing = "Passed";
            } else {
                standing = "Failed";
            }

            System.out.printf("%-6d%-15s%-6d%-9s%-8.1f%-15s%n",
                    ids[i], names[i], ages[i], courses[i], grades[i], standing);
        }
    }

    static void searchStudentById() {
        System.out.print("Enter Student ID to search: ");
        int searchId = scanner.nextInt();

        boolean found = false;

        for (int i = 0; i < count; i++) {
            if (ids[i] == searchId) {
                System.out.println(">> Student found!");
                System.out.println("ID       : " + ids[i]);
                System.out.println("Name     : " + names[i]);
                System.out.println("Age      : " + ages[i]);
                System.out.println("Course   : " + courses[i]);
                System.out.println("Grade    : " + grades[i]);
                System.out.println("Enrolled : " + enrolled[i]);
                found = true;
            }
        }

        if (!found) {
            System.out.println(">> Student with ID " + searchId + " not found.");
        }
    }

    static void viewStatistics() {
        System.out.println("--- STATISTICS ---");

        if (count == 0) {
            System.out.println("No student records available.");
            return;
        }

        double total = 0;
        int topIndex = 0;

        for (int i = 0; i < count; i++) {
            total = total + grades[i];
            if (grades[i] > grades[topIndex]) {
                topIndex = i;
            }
        }

        double average = total / count;

        System.out.println("Total Students : " + count);
        System.out.printf("Average Grade  : %.2f%n", average);
        System.out.printf("Top Student    : %s (%.1f)%n", names[topIndex], grades[topIndex]);
    }
}