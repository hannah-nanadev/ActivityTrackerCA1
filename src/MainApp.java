import java.util.Scanner;
import java.util.Comparator;
import java.util.Collections;

public class MainApp {
    public static void main(String[] args){ //Main menu + importer
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
                    "\n3: Search" +
                    "\n4: Get averages" +
                    "\n5: View all of a specific activity" +
                    "\n6: Exit");
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
                    searchMenu(tracker);
                    break;
                case 4:
                    getAverages(tracker);
                    break;
                case 5:
                    viewAllOf(tracker);
                    break;
                case 6:
                    System.out.println("Thank you!");
                    running = false;
            }

        }
    }

    public static void viewMenu(ActivityTracker tracker) //View Activity
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

    public static void sortMenu(ActivityTracker tracker) //Sort Activities
    {
        System.out.println("Sort activities how?"
        +"\n1: By activity type"
        +"\n2: By duration"
        +"\n3: By distance"
        +"\n4: By calories burned"
        +"\n5: Back");

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
            case 4:
                Comparator<Activity> compCal = new CalorieCompare();
                Collections.sort(tracker.getActivities(), compCal);
                break;
        }
        if(selection<5&&selection>0)
        {
            System.out.println("Ascending or descending?" +
                    "\n1: Ascending" +
                    "\n2: Descending");
            int sel2 = sc.nextInt();

            if(sel2==2)
            {
                Collections.reverse(tracker.getActivities());
            }

            System.out.println("Sorted!");

        }

    }

    public static void searchMenu(ActivityTracker tracker) //Search
    {
        System.out.println("Please enter the type of activity you're looking for.");
        Scanner sc = new Scanner(System.in);
        String selected = sc.nextLine();

        Activity key = new Activity(selected, "", 0, 0, 0);
        Comparator<Activity> compAct = new ActivityCompare();

        int index = Collections.binarySearch(tracker.getActivities(), key, compAct);

        if(index>=0)
        {
            System.out.println(tracker.getActivity(index).toString());
            System.out.println("Found at index " + (index+1));
        }
        else {
            System.out.println("Not found.");
        }
    }

    public static void getAverages(ActivityTracker tracker) //Get Averages
    {
        System.out.println("Average distance per activity: " + tracker.avgDistance()
        + "\nAverage calories burned per activity: " + tracker.avgCalsBurned());
    }

    public static void viewAllOf(ActivityTracker tracker) //View all of a specific activity
    {
        boolean valid = false;

        while(!valid)
        {
            System.out.println("What type of activity would you like to search for?" +
                    "\n(Type -1 to cancel.)");
            Scanner sc = new Scanner(System.in);
            String selection = sc.nextLine();

            if(selection.equals("-1"))
            {
                break;
            }
            valid = true;
            for(int i = 0; i<tracker.getLength(); i++)
            {
                if(tracker.getActivity(i).getType().equals(selection))
                {
                    System.out.println(tracker.getActivity(i).toString());
                }
            }

        }
    }

}
