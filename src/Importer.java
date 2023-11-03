import java.io.*;
import java.util.Scanner;

public class Importer{

    public ActivityTracker in(String fileName)
    {
        try(Scanner sc = new Scanner(new File(fileName)))
        {
            System.out.println("File found!");
        }
        catch(FileNotFoundException exception)
        {
            System.out.println("File not found.");
        }
    }

}
