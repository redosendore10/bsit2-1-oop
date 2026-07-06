import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        boolean running = true;

        while (running) {
            System.out.println("Student Information System");
            System.out.println("1. add student");
            System.out.println("2. view student");
            System.out.println("3. search");
            System.out.println("4. view statistics");
            System.out.println("5. exit terminal");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: break;
                case 2: break;
                case 3: break;
                case 4: break;
                case 5: running = false; break;
                default:
            }
        }
    }
}