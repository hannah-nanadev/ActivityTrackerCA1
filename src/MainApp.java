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
        boolean running = true;

        while(running)
        {
            int selection;
            System.out.println("What would you like to do?" +
                    "\n1: View Activity" +
                    "\n2: Sort Activities" +
                    "\n3: Exit");
            Scanner sc2 = new Scanner(System.in);
            selection = sc2.nextInt();

            switch(selection)
            {
                case 1:
                    viewMenu(tracker);
                    break;
                case 2:
                    System.out.println("Currently unimplemented.");
                    break;
                case 3:
                    System.out.println("Thank you!");
                    running = false;
            }

        }
    }

    public static void viewMenu(ActivityTracker tracker)
    {
        boolean running = true;
        while(running)
        {
            System.out.println("There are " + tracker.getLength() + " activities logged." +
                    "\nPlease enter a number, or enter -1 to go back.");
            Scanner sc = new Scanner(System.in);
            int selected = sc.nextInt();

            if(selected==-1)
            {
                running = false;
            }
            else
            {
                System.out.println(tracker.getActivity(selected).toString());
            }
        }
    }
}
