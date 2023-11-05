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

    //Getter for an activity
    public ArrayList<Activity> getActivities()
    {
        return activities;
    }

    //Adds activity to list
    public void addActivity(Activity a)
    {
        activities.add(a);
    }

}
