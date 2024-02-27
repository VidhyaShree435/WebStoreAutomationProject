package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationUtils {

	 public static String getProperty(String filePath, String key) {
	        Properties prop = new Properties();
	        try {
	            prop.load(new FileInputStream(filePath));
	            return prop.getProperty(key);
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return null;
	    }
}
