package util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {
    private static final String LOG_FILE = "log.txt";

    public static void log(String message) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(LOG_FILE, true));
            writer.println(message);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
