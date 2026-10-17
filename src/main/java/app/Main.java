package app;

import facade.AdminFacade;
import facade.ProctoringFacade;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProctoringFacade facade = new ProctoringFacade();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Run Successful Chain (A -> B -> C)");
            System.out.println("2. Simulate Step B Failure (Rollback A)");
            System.out.println("3. Simulate Step C Failure (Rollback B -> A)");
            System.out.println("4. Inspect System State (Admin Facade)");
            System.out.println("5. Exit");
            System.out.print("Select option: ");

            int choice = scanner.nextInt();
            if (choice == 1) {
                facade.runExamChain("Student123", false, false);
            } else if (choice == 2) {
                facade.runExamChain("Student123", true, false);
            } else if (choice == 3) {
                facade.runExamChain("Student123", false, true);
            } else if (choice == 4) {
                new AdminFacade().inspectSystemState();
            } else {
                break;
            }
        }
    }
}