package framework.utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class Reports {

    // This method would push environment.properties to allure-results directory
    public static void createProperties() {
        OutputStream fos = null;
        Properties prop = null;

        try {
            prop = new Properties();

            File file = new File(System.getProperty("user.dir") + "/build/allure-results/environment.properties");

            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }

            fos = new FileOutputStream(file);

            // set the properties value
            prop.setProperty("os.name", System.getProperty("os.name"));
            prop.setProperty("os.version", System.getProperty("os.version"));
            prop.setProperty("suite", "API");
            prop.setProperty("environment", "test");
            prop.setProperty("user", System.getProperty("user.name"));

            prop.store(fos, "storing");

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                    prop.clear();
                } catch (IOException e) {
                    e.printStackTrace(System.out);
                }
            }
        }

    }

    //Following method would copy history folder from allure-report and push it to allure-results
    public static void copyHistory() {

        try {
            String sourceDirectoryLocation = System.getProperty("user.dir") + "/build/reports/allure-report/history";
            String destinationDirectoryLocation = System.getProperty("user.dir") + "/build/allure-results/history";

            File sourceDirectory = new File(sourceDirectoryLocation);
            File destinationDirectory = new File(destinationDirectoryLocation);

            if (!destinationDirectory.exists())
                destinationDirectory.mkdir();

            FileUtils.copyDirectory(sourceDirectory, destinationDirectory);
        } catch (IOException e) {
            System.out.println("Failed to copy history directory");
        }
    }


    public static void main(String[] args) {
        createProperties();
        copyHistory();
    }
}
