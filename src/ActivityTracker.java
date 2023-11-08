import java.util.ArrayList;

public class ActivityTracker {

    //Variables
    private ArrayList<Activity> activities;

    //Constructors
    public ActivityTracker(ArrayList<Activity> activities)
    {
        this.activities = activities;
    }
    public ActivityTracker(ActivityTracker imported)
    {
        this.activities = imported.getActivities();
    }

    public ActivityTracker()
    {
        this.activities = new ArrayList<Activity>();
    }

    //Getters
    public ArrayList<Activity> getActivities()
    {
        return activities;
    }

    public Activity getActivity(int no)
    {
        return activities.get(no);
    }

    public int getLength()
    {
        return activities.size();
    }

    //Adds activity to list
    public void addActivity(Activity a)
    {
        activities.add(a);
    }

    //Functionality
    public double avgDistance()
    {
        double avg = 0;

        for(int i = 0; i<activities.size(); i++)
        {
            avg = avg+activities.get(i).getDistance();
        }

        return avg/activities.size();

    }

    public double avgCalsBurned()
    {
        double avg = 0;

        for(int i = 0; i<activities.size(); i++)
        {
            avg = avg+activities.get(i).getCalsBurned();
        }

        return avg/activities.size();
    }

}
