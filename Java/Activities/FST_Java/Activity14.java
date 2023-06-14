package org.activities;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class Activity14 {
    public static void main(String[] args) throws IOException {
        try {
            String userDir = System.getProperty("user.dir");
            File file = new File(userDir + "\\src\\test\\resources\\newfile.txt");
            boolean fileStatus = file.createNewFile();
            if (fileStatus)
                System.out.println("The file has been created");
            else
                System.out.println("The file doesn't exist");

            File fileUtil = FileUtils.getFile(userDir + "\\src\\test\\resources\\newfile.txt");
            FileUtils.readFileToString(fileUtil, "UTF8");

            File newDir = new File("resources");
            FileUtils.copyFileToDirectory(file, newDir);

            File newFile = FileUtils.getFile(newDir, "newfile.txt");
            String newFileData = FileUtils.readFileToString(newFile, "UTF8");
            System.out.println("New File Data is: " + newFileData);
        } catch (IOException errMessage) {
            System.out.println(errMessage);
        }
    }
}
