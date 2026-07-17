import java.util.ArrayList;
import java.util.Scanner;

public class App {

    static ArrayList<Double> cutoffs = new ArrayList<>();
    static ArrayList<Character> letters = new ArrayList<>();

    static {
        cutoffs.add(90.0);
        cutoffs.add(80.0);
        cutoffs.add(70.0);
        cutoffs.add(60.0);

        letters.add('A');
        letters.add('B');
        letters.add('C');
        letters.add('D');
    }

    static char letterFor(double grade) {
        for (int i = 0; i < cutoffs.size(); i++) {
            if (grade >= cutoffs.get(i)) {
                return letters.get(i);
            }
        }
        return 'F';
    }

    public static void main(String[] args) {
        ArrayList<Student> roster = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n Grade Tracker");
            System.out.println("1. Add  new student");
            System.out.println("2. View all students");
            System.out.println("3. Class average");
            System.out.println("4. Exit");
            System.out.print("Choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Name: ");
                String name = sc.next();
                System.out.print("Grade (0-100): ");
                double grade = sc.nextDouble();

                roster.add(new Student(name, grade));
                System.out.println("Added " + name + "!");

            } else if (choice == 2) {
                if (roster.isEmpty()) {
                    System.out.println("No students yet.");
                } else {
                    for (Student s : roster) {
                        System.out.println(s.name + " - " + s.grade + " (" + letterFor(s.grade) + ")");
                    }
                }

            } else if (choice == 3) {
                if (roster.isEmpty()) {
                    System.out.println("No students yet.");
                } else {
                    double total = 0;
                    for (Student s : roster) {
                        total += s.grade;
                    }
                    double average = total / roster.size();
                    System.out.printf("Class average: %.2f (%s)%n", average, letterFor(average));
                }

            } else if (choice == 4) {
                running = false;
                System.out.println("Bye");

            } else {
                System.out.println("Invalid choice. Pick 1-4.");
            }
        }

        sc.close();
    }
}

class Student {
    String name;
    double grade;

    Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }
}
