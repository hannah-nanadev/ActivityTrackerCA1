import java.util.ArrayList;

public class ActivityTracker {

    //Variables
    private ArrayList<Activity> activities;

    //Constructors
    public ActivityTracker(ActivityTracker imported)
    {
        this.activities = imported.getActivities();
    }

    public ArrayList<Activity> getActivities()
    {
        return activities;
    }

    public void addActivity(Activity a)
    {
        activities.add(a);
    }

}
