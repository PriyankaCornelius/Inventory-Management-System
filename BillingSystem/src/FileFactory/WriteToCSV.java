package FileFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;  // Import the IOException class to handle errors
public class WriteToCSV implements WriteToFile{
    @Override
    public void writeToFile(String message) {
        System.out.println("inside write to csv");
        try {
            File errorFile = new File("output.csv");
            if (errorFile.createNewFile()) {
                System.out.println("File created: " + errorFile.getName());
            } else {
                System.out.println("output.csv File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            FileWriter myWriter = new FileWriter("output.csv");
            myWriter.write("Amount Paid : "+ message);
            myWriter.close();
            System.out.println("Successfully wrote to the file output.csv .");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
}
