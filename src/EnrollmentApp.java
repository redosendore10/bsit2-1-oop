    import java.util.ArrayList;
    import java.util.HashMap;
    import java.util.Scanner;
    
    public class EnrollmentApp {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
    
            ArrayList<Student> students = new ArrayList<>();
            ArrayList<Course> courses = new ArrayList<>();
            HashMap<String, ArrayList<String>> enrollments = new HashMap<>();
            String[] validPrograms = {"BSIT", "BSCS"};
    
            int choice = -1;
            while (choice != 0) {
                printMenu();
                try {
                    choice = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    continue;
                }
    
                switch (choice) {
                    case 1: // Register Student
                        System.out.print("Student ID   : ");
                        String id = sc.nextLine();
    
                        if (findStudent(students, id) != null) {
                            System.out.println("[ERROR] Student ID already exists!");
                            break;
                        }
    
                        System.out.print("Full Name    : ");
                        String name = sc.nextLine();
    
                        System.out.print("Program (BSIT/BSCS): ");
                        String prog = sc.nextLine().toUpperCase();
    
                        // Validate program input
                        boolean isValidProg = false;
                        for (String vp : validPrograms) {
                            if (vp.equals(prog)) {
                                isValidProg = true;
                                break;
                            }
                        }
    
                        if (!isValidProg) {
                            System.out.println("[ERROR] Invalid Program! Must be BSIT or BSCS.");
                            break;
                        }
    
                        System.out.print("Year Level   : ");
                        int year = Integer.parseInt(sc.nextLine());
    
                        students.add(new Student(id, name, prog, year));
                        System.out.println("[OK] Registered successfully!");
                        break;
    
                    case 2:
                        System.out.println("Feature pending...");
                        break;
    
                    case 3:
                        System.out.println("Feature pending...");
                        break;
    
                    case 0:
                        System.out.println("Thank you!");
                        break;
    
                    default:
                        System.out.println("Invalid choice.");
                }
            }
            sc.close();
        }
    
        static void printMenu() {
            System.out.println("\n--- MENU ---");
            System.out.println("[1] Register Student");
            System.out.println("[2] Create Course");
            System.out.println("[3] Enroll Student in Course");
            System.out.println("[0] Exit");
            System.out.print("Enter choice: ");
        }
    
        static Student findStudent(ArrayList<Student> list, String id) {
            for (Student s : list) {
                if (s.getStudentId().equalsIgnoreCase(id)) {
                    return s;
                }
            }
            return null; // way makita

        }
    }
