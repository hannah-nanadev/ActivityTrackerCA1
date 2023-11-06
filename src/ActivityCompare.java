import java.util.Comparator;
//Recieved help for this from Ciara Clerkin, GD2A
public class ActivityCompare implements Comparator<Activity>{
    @Override
    public int compare(Activity a1, Activity a2)
    {
        return a1.getType().compareTo(a2.getType());
    }
    public int compareDuration(Activity a1, Activity a2)
    {
        return Integer.compare(a1.getDuration(), a2.getDuration());
    }
    public int compareDistance(Activity a1, Activity a2)
    {
        return Double.compare(a1.getDistance(), a2.getDistance());
    }

    public int compareLevel(Activity a1, Activity a2)
    {
        return a1.getLevel().compareTo(a2.getLevel());
    }
}
