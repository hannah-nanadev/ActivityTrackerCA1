import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class MainApp {
    public static void main(String[] args){
        System.out.println("Welcome to Activity Tracker!");
        ActivityTracker tracker = null;
        while(tracker==null)
        {
            System.out.print("Please enter the filename of your csv file.\n>");

            Scanner sc = new Scanner(System.in);
            String filename = sc.nextLine();
            tracker = Importer.in(filename);

            if(tracker==null)
                System.out.println("Please try again.");
        }
        System.out.println("Import successful!");
    }
}
