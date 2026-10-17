package subsystemB;

import java.io.*;

public class SubsystemBPersistence {
    private static final String FILE_PATH = "data/subsystemB.txt";

    public void save(ProctoringRecord record) {
        new File("data").mkdirs();
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH))) {
            writer.println(record.getId() + "," + record.getStatus());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}