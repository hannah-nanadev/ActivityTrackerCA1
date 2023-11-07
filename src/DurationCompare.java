import java.util.Comparator;
public class DurationCompare implements Comparator<Activity> {
    @Override
    public int compare(Activity a1, Activity a2)
    {
        return Integer.compare(a1.getDuration(), a2.getDuration());
    }
}
