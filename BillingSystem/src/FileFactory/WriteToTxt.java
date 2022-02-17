package FileFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToTxt implements WriteToFile{

    @Override
    public void writeToFile(String message) {
        System.out.println("inside write to txt");
        try {
            File errorFile = new File("error.txt");
            if (errorFile.createNewFile()) {
                System.out.println("File created: " + errorFile.getName());
            } else {
                System.out.println("error.txt File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            FileWriter myWriter = new FileWriter("error.txt");
            myWriter.write("Please correct quantities : " + message);
            myWriter.close();
            System.out.println("Successfully wrote to the file error.txt .");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
