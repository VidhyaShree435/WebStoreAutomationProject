package utilities;

import java.io.File;

public class FileUtils {

	public static void createDirectory(String directoryPath) {
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }
}
