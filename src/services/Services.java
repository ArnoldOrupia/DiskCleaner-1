
package services;

import java.io.File;
import java.util.ArrayList;//arraylist stores elements in an array
import java.util.List;

//generates temporary files from the folders
public class Services {

    private static List<String> fullCleanFiles = new ArrayList<>();
    private static File f = null;
    private static String[] paths;

    public static List<String> getServices(String s) {  //method to generate files
        List<String> temporaryFiles = new ArrayList<>();

        File file;
        String[] paths;

        try {
            file = new File(s);
            paths = file.list();

            for (String path : paths) {  //for each loop
                temporaryFiles.add(path);
            }
            return temporaryFiles;
        } catch (Exception e) {
            e.printStackTrace();// doesnt display the error found
            return new ArrayList<>();
        }
    }
        public static List<String> getFullCleanFiles() {

        List<String> allFiles = null;
        String[] folder = {"C:\\Windows\\Prefetch", "C:/Windows/Temp", "C:/Users/FRIDAH/AppData/Local/Temp"};

        for (int i = 0; i < folder.length; i++) {
            allFiles = displayer(folder[i]);
        }

        return allFiles;
    }
            public static List<String> displayer(String s) {

        try {
            f = new File(s);
            paths = f.list();

            for (String path : paths) {
                fullCleanFiles.add(path);
            }
            return fullCleanFiles;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }


}
