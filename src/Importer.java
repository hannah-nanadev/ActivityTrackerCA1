import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Importer{

    public static ActivityTracker in(String fileName)
    {
        //Code taken and adapted from https://github.com/logued/oop-csv-read-text-file/blob/master/src/main/java/org/example/Main.java
        try(Scanner sc = new Scanner(new File(fileName)))
        {
            if(sc.hasNextLine())
                sc.nextLine(); //Reads headers but doesn't use them

            //Initialises ArrayList
            ArrayList<Activity> list = new ArrayList<Activity>();

            //Reads one line at a time into a string and parses into tokens
            while(sc.hasNextLine())
            {
                String line = sc.nextLine();
                String[] tokens = line.split(", "); //Splits with , as delimiter

                //Extracts strings, ints, doubles from tokens
                String type = tokens[0];
                String date = tokens[1];
                int duration = Integer.parseInt(tokens[2]);
                double distance = Double.parseDouble(tokens[3]);
                int avgHeartRate = Integer.parseInt(tokens[4]);

                //Creates new Activity and adds it to list
                list.add(new Activity(type, date, duration, distance, avgHeartRate));
            }

            return new ActivityTracker(list);

        }
        catch(FileNotFoundException exception)
        {
            System.out.println("File not found.");
            return null;
        }
    }

}
