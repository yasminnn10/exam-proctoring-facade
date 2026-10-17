package facade;

import java.io.File;
import java.util.Scanner;

public class AdminFacade {
    public void inspectSystemState() {
        System.out.println("=== SYSTEM STATE INSPECTION ===");
        printFileContent("data/progress.txt", "Chain Progress");
        printFileContent("data/subsystemA.txt", "Subsystem A State");
        printFileContent("data/subsystemB.txt", "Subsystem B State");
        printFileContent("data/subsystemC.txt", "Subsystem C State");
    }

    private void printFileContent(String path, String label) {
        File file = new File(path);
        if (!file.exists()) {
            System.out.println(label + ": [No Data]");
            return;
        }
        try (Scanner scanner = new Scanner(file)) {
            if (scanner.hasNextLine()) {
                System.out.println(label + ": " + scanner.nextLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}