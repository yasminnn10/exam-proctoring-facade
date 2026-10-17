package subsystemA;

import java.io.*;

public class SubsystemAPersistence {
    private static final String FILE_PATH = "data/subsystemA.txt";

    public void save(ExamSession session) {
        new File("data").mkdirs();
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH))) {
            writer.println(session.getId() + "," + session.getStatus());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}