import java.util.Comparator;
public class DistanceCompare implements Comparator<Activity> {
    @Override
    public int compare(Activity a1, Activity a2)
    {
        return Double.compare(a1.getDistance(), a2.getDistance());
    }
}
