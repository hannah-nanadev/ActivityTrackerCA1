import java.util.Collection;
import java.util.Scanner;
import java.util.Comparator;
import java.util.Collections;

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
                    sortMenu(tracker);
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
                selected--;
                System.out.println(tracker.getActivity(selected).toString());
            }
        }
    }

    public static void sortMenu(ActivityTracker tracker)
    {
        System.out.println("Sort activities how?"
        +"\n1: By activity type"
        +"\n2: By duration"
        +"\n3: By distance"
        +"\n4: By intensity level"
        +"\n5: By calories burned"
        +"\n6: Back");

        Scanner sc = new Scanner(System.in);
        int selection = sc.nextInt();

        switch(selection)
        {
            case 1: //By activity type
                Comparator<Activity> compAct = new ActivityCompare();
                Collections.sort(tracker.getActivities(), compAct);
                break;
            case 2: //By duration
                Comparator<Activity> compDur = new DurationCompare();
                Collections.sort(tracker.getActivities(), compDur);
                break;
            case 3: //By distance
                Comparator<Activity> compDis = new DistanceCompare();
                Collections.sort(tracker.getActivities(), compDis);
                break;
            case 4: //By intensity level
                Comparator<Activity> compInt = new LevelCompare();
                Collections.sort(tracker.getActivities(), compInt);
                break;
            case 5:
                Comparator<Activity> compCal = new CalorieCompare();
                Collections.sort(tracker.getActivities(), compCal);
                break;
        }
        if(selection<6&&selection>0)
        {
            System.out.println("Sorted!");
        }

    }
}
